package com.relationalai.util.auth;

import com.google.common.escape.Escaper;
import com.google.common.net.UrlEscapers;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.File;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.JSchException;

import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeysetHandle;

import java.security.GeneralSecurityException;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;

import com.relationalai.util.InvalidRequestException;
import com.relationalai.util.RaiLogger;
import com.relationalai.util.FormattingUtil;

public class ClientSideAuthenticationUtil
{
    final static Logger LOGGER = RaiLogger.getLogger(MethodHandles.lookup().lookupClass());

    public static final String AUTHORIZATION_HEADER = "authorization";

    /**
     * String-to-sign:
     * Algorithm (e.g. RAI01-ED25519-SHA256) + \n +
     * CredentialScope + \n +
     * HashedCanonicalRequest
     **/
    public static String getStringToSign(FullHttpRequest req, AuthorizationInfo authInfo)
        throws NoSuchAlgorithmException, InvalidRequestException, UnsupportedEncodingException
    {
        StringBuilder stringToSign = new StringBuilder();

        stringToSign.append(authInfo.getMethod().getStringForSignature());
        stringToSign.append("\n");

        stringToSign.append(authInfo.getCredentialScope().getStringForSignature());
        stringToSign.append("\n");

        stringToSign.append(hashedCanonicalRequest(req));

        return stringToSign.toString();
    }

    public static String getStringToSign(FullHttpRequest req, String accessKey, String region, String service)
        throws NoSuchAlgorithmException, InvalidRequestException, UnsupportedEncodingException
    {
        StringBuilder stringToSign = new StringBuilder();

        // Append Algorithm (e.g. RAI01-ED25519-SHA256)
        stringToSign.append(new AuthorizationMethod().getStringForSignature());
        stringToSign.append("\n");

        Date date = new Date();

        // Append YYYYMMDD'T'HHMMSS'Z' date?
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        // stringToSign.append(dateFormat.format(date));
        // stringToSign.append("\n");

        // CredentialScope
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateFormatted = dateFormat.format(date);
        CredentialScope credScope = new CredentialScope(accessKey, dateFormatted, region, service, CredentialScope.TERMINATION_STRING);
        stringToSign.append(credScope.getStringForSignature());
        stringToSign.append("\n");

        // Canonical Request
        String canonicalRequest = hashedCanonicalRequest(req);
        stringToSign.append(canonicalRequest);

        return stringToSign.toString();
    }

    /**
     * Compute the content of the authorization header, for CLIENT to include in the request
     *
     * Authorization header if of the following form:
     * <Algorithm (e.g. RAI01-ED25519-SHA256)> Credential=<CredentialScope>,SignedHeaders=<Headers>,Signature=<Signature>
     *
     **/
    public static String makeAuthorizationHeader(FullHttpRequest req, String accessKey, String region, String serviceName, String signatureHex)
        throws NoSuchAlgorithmException, InvalidRequestException, UnsupportedEncodingException
    {
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
    public static String hashedCanonicalRequest(FullHttpRequest req)
        throws NoSuchAlgorithmException, InvalidRequestException, UnsupportedEncodingException
    {
        HttpMethod reqMethod = req.method();

        StringBuilder canonicalRequest = new StringBuilder();
        canonicalRequest.append(reqMethod.name() + "\n");

        // add the path, query parameters & values;
        canonicalRequest.append(canonicalURI(req));

        // add the canonical headers & signed headers
        canonicalRequest.append(canonicalAndSignedHeaders(req));

        // add hashed payload
        canonicalRequest.append(hashedPayload(req));
        LOGGER.debug("canonicalRequest=\n" + canonicalRequest.toString());

        return hashBytes(canonicalRequest.toString().getBytes());
    }

    public static String hashedPayload(FullHttpRequest req) throws NoSuchAlgorithmException
    {
        ByteBuf reqContent = req.content();
        byte[] reqBytes = new byte[reqContent.readableBytes()];
        int readerIndex = reqContent.readerIndex();
        reqContent.getBytes(readerIndex, reqBytes);

        String hashedPayload = hashBytes(reqBytes);

        return hashedPayload;
    }

    private static String hashBytes(byte[] reqBytes) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(reqBytes);

        return FormattingUtil.toHexString(hash).toLowerCase();
    }

    public static List<String> getSignedHeaders(FullHttpRequest req) throws InvalidRequestException
    {
        ArrayList<String> headers = new ArrayList<String>();

        HttpHeaders reqHeaders = req.headers();
        if ( !reqHeaders.contains("content-type"))
        {
            throw new InvalidRequestException("Missing required headers content-type");
        }
        else
        {
            headers.add("content-type");
        }

        if ( !reqHeaders.contains("authority") && !reqHeaders.contains("host"))
        {
            throw new InvalidRequestException("Missing required headers authority");
        }
        else if ( reqHeaders.contains("authority") )
        {
            headers.add("authority");
        }
        else
        {
            headers.add("host");
        }
        Collections.sort(headers);

        return headers;
    }

    public static String canonicalAndSignedHeaders(FullHttpRequest req) throws InvalidRequestException
    {
        StringBuilder canonicalHeaders = new StringBuilder();

        HttpHeaders reqHeaders = req.headers();
        if ( !reqHeaders.contains("content-type"))
        {
            throw new InvalidRequestException("Missing required headers content-type");
        }

        if ( !reqHeaders.contains("authority") && !reqHeaders.contains("host"))
        {
            throw new InvalidRequestException("Missing required headers authority");
        }

        canonicalHeaders.append("content-type:");
        canonicalHeaders.append(reqHeaders.get("content-type").trim());
        canonicalHeaders.append("\n");

        if ( reqHeaders.contains("authority"))
        {
            canonicalHeaders.append("authority:");
            canonicalHeaders.append(reqHeaders.get("authority").trim());
            canonicalHeaders.append("\n");
        }
        if ( reqHeaders.contains("host"))
        {
            canonicalHeaders.append("host:");

            // Sometimes host has port, and sometimes not. Get rid of the port
            String hostStr = reqHeaders.get("host");
            int colon = hostStr.indexOf(":");
            if ( colon > 0 )
                hostStr = hostStr.substring(0, colon);
            canonicalHeaders.append(hostStr.trim());
            canonicalHeaders.append("\n");
        }
        canonicalHeaders.append("\n");

        // add signed headers
        if ( reqHeaders.contains("authority"))
        {
            canonicalHeaders.append("authority;content-type");
        }
        else
        {
            canonicalHeaders.append("content-type;host");
        }
        canonicalHeaders.append("\n");
        return canonicalHeaders.toString();
    }

    public static String canonicalURI(FullHttpRequest req) throws UnsupportedEncodingException
    {
        // get the path, query parameters & values;
        QueryStringDecoder queryString = new QueryStringDecoder(req.uri());

        // Canonical path
        StringBuilder canonicalRequest = new StringBuilder();
        Escaper escaper = UrlEscapers.urlPathSegmentEscaper();
        List<String> escapedSegments = new ArrayList();
        for (String segment : queryString.path().split("/"))
        {
            escapedSegments.add(escaper.escape(escaper.escape(segment)));
        }
        String escapedPath = String.join("/", escapedSegments);
        if (escapedPath.isEmpty())
        {
            canonicalRequest.append('/');
        }
        else
        {
            canonicalRequest.append(escapedPath);
        }
        canonicalRequest.append('\n');

        // Canonical query string
        // sort the parameters
        Map<String,List<String>> params = queryString.parameters();
        if ( params.size() > 0 )
        {
            List<String> paramsTmp = new ArrayList();
            TreeMap<String,List<String>> sortedParams = new TreeMap(params);
            for ( Map.Entry<String, List<String>>  entry : sortedParams.entrySet() )
            {
                // sort the values.
                ArrayList<String> values = new ArrayList(entry.getValue());
                Collections.sort(values);

                List<String> paramTmp = new ArrayList();
                for ( String value : values )
                {
                    StringBuilder paramSB = new StringBuilder();
                    paramSB.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    paramSB.append("=");
                    String valueEnc = URLEncoder.encode(value, "UTF-8");
                    String encodedEquals = URLEncoder.encode("=", "UTF-8");
                    if (valueEnc.contains(encodedEquals))
                    {
                        // Double-encode '='
                        valueEnc = valueEnc.replaceAll(encodedEquals, URLEncoder.encode(encodedEquals, "UTF-8"));
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
        throws GeneralSecurityException, IOException
    {
        String tinkJson = JsonIterator.deserialize(keyString).get("tink").toString();
        KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withString(tinkJson));
        return keysetHandle;
    }

    public static KeysetHandle getKeysetHandle(File keysetFile) throws Exception
    {
        String json = JsonIterator.deserialize(Files.readAllBytes(keysetFile.toPath())).toString();
        return getKeysetHandle(json);
    }

    public static String getKey(KeysetHandle keysetHandle) throws IOException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CleartextKeysetHandle.write(keysetHandle,
            JsonKeysetWriter.withOutputStream(outputStream));
        return new String(outputStream.toByteArray());
    }

    public static String getRawKey(KeysetHandle keysetHandle) throws IOException
    {
        String keyJson = getKey(keysetHandle);
        Any any = JsonIterator.deserialize(keyJson);
        Any keyArr = any.get("key");
        for ( Any key : keyArr.asList())
        {
            return key.get("keyData").get("value").toString();
        }

        return null;
    }

    public static SshPublicPrivateKey generateSSHKeys(String passPhrase, String comment)
        throws JSchException
        {
        JSch jsch = new JSch();
        KeyPair keyPair = KeyPair.genKeyPair(jsch, KeyPair.RSA);
        ByteArrayOutputStream privateKeyBuff = new ByteArrayOutputStream(2048);
        ByteArrayOutputStream publicKeyBuff = new ByteArrayOutputStream(2048);

        keyPair.writePublicKey(publicKeyBuff, (comment != null) ? comment : "SSHCerts");

        if (passPhrase == null  || passPhrase.isEmpty())
        {
            keyPair.writePrivateKey(privateKeyBuff);
        }
        else
        {
            keyPair.writePrivateKey(privateKeyBuff, passPhrase.getBytes());
        }

        return new SshPublicPrivateKey(privateKeyBuff.toString(), publicKeyBuff.toString());
    }

    public static class SshPublicPrivateKey {
        private String sshPublicKey;
        private String sshPrivateKey;

        /**
         * Constructor.
         * @param sshPrivateKey SSH private key
         * @param sshPublicKey SSH public key
         */
        public SshPublicPrivateKey(String sshPrivateKey, String sshPublicKey) {
            this.sshPrivateKey = sshPrivateKey;
            this.sshPublicKey = sshPublicKey;
        }

        /**
         * Get SSH public key.
         * @return public key
         */
        public String getSshPublicKey() {
            return sshPublicKey;
        }

        /**
         * Get SSH private key.
         * @return private key
         */
        public String getSshPrivateKey() {
            return sshPrivateKey;
        }

        /**
         * Set SSH public key.
         * @param sshPublicKey public key
         */
        public void setSshPublicKey(String sshPublicKey) {
            this.sshPublicKey = sshPublicKey;
        }

        /**
         * Set SSH private key.
         * @param sshPrivateKey private key
         */
        public void setSshPrivateKey(String sshPrivateKey) {
            this.sshPrivateKey = sshPrivateKey;
        }
    }
}
