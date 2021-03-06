package com.relationalai.util.auth;

import com.google.common.escape.Escaper;
import com.google.common.net.UrlEscapers;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.relationalai.util.FormattingUtil;
import com.relationalai.util.InvalidRequestException;
import com.relationalai.util.RaiLogger;
import io.netty.handler.codec.http.QueryStringDecoder;
import okhttp3.Headers;
import okhttp3.Request;
import okio.Buffer;
import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClientSideAuthenticationUtil {
    public static final String AUTHORIZATION_HEADER = "authorization";
    final static Logger LOGGER = RaiLogger.getLogger(MethodHandles.lookup().lookupClass());
    public static final String RAIDATE_HEADER = "x-rai-date";
    public static final DateTimeFormatter SIGNATURE_DATE_FORMATTER = DateTimeFormatter
        .ofPattern("yyyyMMdd'T'HHmmss'Z'").withZone(ZoneId.of("UTC"));
    public static final DateTimeFormatter SCOPE_DATE_FORMATTER = DateTimeFormatter
        .ofPattern("yyyyMMdd").withZone(ZoneId.of("UTC"));
    /**
     * String-to-sign:
     * Algorithm (e.g. RAI01-ED25519-SHA256) + \n +
     * CredentialScope + \n +
     * HashedCanonicalRequest
     **/
    public static String getStringToSign(Request req, Instant date, String accessKey, String region, String service)
            throws NoSuchAlgorithmException, InvalidRequestException, IOException {
        StringBuilder stringToSign = new StringBuilder();

        // Append Algorithm (e.g. RAI01-ED25519-SHA256)
        stringToSign.append(new AuthorizationMethod().getStringForSignature());
        stringToSign.append("\n");

        // Date
        stringToSign.append(SIGNATURE_DATE_FORMATTER.format(date));
        stringToSign.append("\n");

        // CredentialScope
        String scopeDateFormatted = SCOPE_DATE_FORMATTER.format(date);
        CredentialScope credScope = new CredentialScope(accessKey, scopeDateFormatted, region, service, CredentialScope.TERMINATION_STRING);
        stringToSign.append(credScope.getStringForSignature());
        stringToSign.append("\n");

        // Canonical Request
        String canonicalRequest = hashedCanonicalRequest(req);
        stringToSign.append(canonicalRequest);

        return stringToSign.toString();
    }

    /**
     * Compute the content of the authorization header, for CLIENT to include in the request
     * <p>
     * Authorization header if of the following form:
     * <Algorithm (e.g. RAI01-ED25519-SHA256)> Credential=<CredentialScope>,SignedHeaders=<Headers>,Signature=<Signature>
     **/
    public static String makeAuthorizationHeader(Request req, String accessKey, String region, String serviceName, String signatureHex)
            throws NoSuchAlgorithmException, InvalidRequestException, UnsupportedEncodingException {
        // Create AuthorizatinoInfo
        AuthorizationMethod method = new AuthorizationMethod();

        // Create credential scope
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(new Date());
        CredentialScope credScope = new CredentialScope(accessKey, date, region, serviceName);

        // Create signed headers
        List<String> signedHeaders = getSignedHeaders(req);

        AuthorizationInfo authInfo = new AuthorizationInfo(method, credScope, signedHeaders, signatureHex);

        return authInfo.getAuthorizationHeaderString();
    }

    /**
     * compute CanonicalRequest =
     * HTTPRequestMethod + '\n' +
     * CanonicalURI + '\n' +
     * CanonicalQueryString + '\n' +
     * CanonicalHeaders + '\n' +
     * SignedHeaders + '\n' +
     * HexEncode(Hash(RequestPayload))
     */
    public static String hashedCanonicalRequest(Request req)
            throws NoSuchAlgorithmException, InvalidRequestException, IOException {
        String reqMethod = req.method();

        StringBuilder canonicalRequest = new StringBuilder();
        canonicalRequest.append(reqMethod + "\n");

        // add the path, query parameters & values;
        canonicalRequest.append(canonicalURI(req));

        // add the canonical headers & signed headers
        canonicalRequest.append(canonicalAndSignedHeaders(req));

        // add hashed payload
        canonicalRequest.append(hashedPayload(req));
        LOGGER.debug("canonicalRequest=\n" + canonicalRequest.toString());

        return hashBytes(canonicalRequest.toString().getBytes());
    }

    public static String hashedPayload(Request req) throws NoSuchAlgorithmException, IOException {
        final Request copy = req.newBuilder().build();
        final Buffer buffer = new Buffer();
        if (copy.body() != null)
            copy.body().writeTo(buffer);
        byte[] reqBytes = buffer.readByteArray();

        LOGGER.debug(
                "Http2Client.hashedPayload: \n" +
                        "stringToHash=\n" +
                        "*********************\n" +
                        new String(reqBytes) +
                        "\n****** End hashed-payload **** \n");

        String hashedPayload = hashBytes(reqBytes);

        return hashedPayload;
    }

    private static String hashBytes(byte[] reqBytes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(reqBytes);

        return FormattingUtil.toHexString(hash).toLowerCase();
    }

    public static List<String> getSignedHeaders(Request req) throws InvalidRequestException {
        ArrayList<String> headers = new ArrayList<String>();

        Headers reqHeaders = req.headers();
        if (reqHeaders.get("content-type") == null) {
            throw new InvalidRequestException("Missing required headers content-type");
        } else {
            headers.add("content-type");
        }

        if (reqHeaders.get("authority") == null && reqHeaders.get("host") == null) {
            throw new InvalidRequestException("Missing required headers authority");
        } else if (reqHeaders.get("authority") != null) {
            headers.add("authority");
        } else {
            headers.add("host");
        }
        Collections.sort(headers);

        return headers;
    }

    /**
     * Given a HTTP Request, this function creates a string from some headers in a canonical
     * format (based on the order of header names). This string is used in creating a
     * signature for the request.
     */
    public static String canonicalAndSignedHeaders(Request req) throws InvalidRequestException {
        StringBuilder canonicalHeaders = new StringBuilder();

        Headers reqHeaders = req.headers();
        if (reqHeaders.get("content-type") == null) {
            throw new InvalidRequestException("Missing required headers content-type");
        }

        if (reqHeaders.get("authority") == null && reqHeaders.get("host") == null) {
            throw new InvalidRequestException("Missing required headers authority");
        }

        canonicalHeaders.append("content-type:");
        canonicalHeaders.append(reqHeaders.get("content-type").trim());
        canonicalHeaders.append("\n");

        if (reqHeaders.get("authority") != null) {
            canonicalHeaders.append("authority:");
            canonicalHeaders.append(reqHeaders.get("authority").trim());
            canonicalHeaders.append("\n");
        }
        if (reqHeaders.get("host") != null) {
            canonicalHeaders.append("host:");

            // Sometimes host has port, and sometimes not. Get rid of the port
            String hostStr = reqHeaders.get("host");
            int colon = hostStr.indexOf(":");
            if (colon > 0) {
                hostStr = hostStr.substring(0, colon);
            }
            canonicalHeaders.append(hostStr.trim());
            canonicalHeaders.append("\n");
        }
        canonicalHeaders.append("\n");

        // add signed headers
        if (reqHeaders.get("authority") != null) {
            canonicalHeaders.append("authority;content-type");
        } else {
            canonicalHeaders.append("content-type;host");
        }
        canonicalHeaders.append("\n");
        return canonicalHeaders.toString();
    }

    public static String canonicalURI(Request req) throws UnsupportedEncodingException {
        // get the path, query parameters & values;
        QueryStringDecoder queryString = new QueryStringDecoder(req.url().uri());

        // Canonical path
        StringBuilder canonicalRequest = new StringBuilder();
        Escaper escaper = UrlEscapers.urlPathSegmentEscaper();
        List<String> escapedSegments = new ArrayList();
        for (String segment : queryString.path().split("/")) {
            escapedSegments.add(escaper.escape(escaper.escape(segment)));
        }
        String escapedPath = String.join("/", escapedSegments);
        if (escapedPath.isEmpty()) {
            canonicalRequest.append('/');
        } else {
            canonicalRequest.append(escapedPath);
        }
        canonicalRequest.append('\n');

        // Canonical query string
        // sort the parameters
        Map<String, List<String>> params = queryString.parameters();
        if (params.size() > 0) {
            List<String> paramsTmp = new ArrayList();
            TreeMap<String, List<String>> sortedParams = new TreeMap(params);
            for (Map.Entry<String, List<String>> entry : sortedParams.entrySet()) {
                // sort the values.
                ArrayList<String> values = new ArrayList(entry.getValue());
                Collections.sort(values);

                List<String> paramTmp = new ArrayList();
                for (String value : values) {
                    StringBuilder paramSB = new StringBuilder();
                    paramSB.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
                    paramSB.append("=");
                    String valueEnc = URLEncoder.encode(value, StandardCharsets.UTF_8);
                    String encodedEquals = URLEncoder.encode("=", StandardCharsets.UTF_8);
                    if (valueEnc.contains(encodedEquals)) {
                        // Double-encode '='
                        valueEnc = valueEnc.replaceAll(encodedEquals, URLEncoder.encode(encodedEquals, StandardCharsets.UTF_8));
                    }
                    paramSB.append(valueEnc);
                    paramTmp.add(paramSB.toString());
                }
                paramsTmp.add(String.join("&", paramTmp));
            }
            canonicalRequest.append(String.join("&", paramsTmp));
        }
        canonicalRequest.append("\n");

        return canonicalRequest.toString();
    }

    public static KeysetHandle getKeysetHandle(String keyString)
            throws GeneralSecurityException, IOException {
        String tinkJson = JsonIterator.deserialize(keyString).get("tink").toString();
        KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withString(tinkJson));
        return keysetHandle;
    }

    public static KeysetHandle getKeysetHandle(File keysetFile) throws GeneralSecurityException, IOException {
        String json = JsonIterator.deserialize(Files.readAllBytes(keysetFile.toPath())).toString();
        return getKeysetHandle(json);
    }

    public static String getKey(KeysetHandle keysetHandle) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CleartextKeysetHandle.write(keysetHandle,
                JsonKeysetWriter.withOutputStream(outputStream));
        return new String(outputStream.toByteArray());
    }
}
