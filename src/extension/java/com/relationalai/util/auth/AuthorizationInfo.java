package com.relationalai.util.auth;

import com.relationalai.util.FormattingUtil;

import java.util.Arrays;
import java.util.List;

public class AuthorizationInfo {
    public static final String CREDENTIAL_PREFIX = "Credential=";
    public static final String SIGNEDHEADERS_PREFIX = "SignedHeaders=";
    public static final String SIGNATURE_PREFIX = "Signature=";
    final AuthorizationMethod method;
    final CredentialScope credentialScope;
    final List<String> signedHeaders;
    final String signatureHex;


    public AuthorizationInfo(AuthorizationMethod method, CredentialScope credentialScope, List<String> signedHeaders, String signatureHex) {
        this.method = method;
        this.credentialScope = credentialScope;
        this.signedHeaders = signedHeaders;
        this.signatureHex = signatureHex;
    }

    /**
     * Expected format of the authorizationStr:
     * <SIGNATURE-METHOD> Credential=<CREDENTIAL>,SignedHeaders=<HEADERS>,Signature=<SIGNATURE>
     */
    public static AuthorizationInfo parse(String authorizationStr)
            throws BadAuthorizationHeaderFormatException, BadCredentialFormatException, InvalidAuthorizationMethodException {
        int nlind = authorizationStr.indexOf(CREDENTIAL_PREFIX);
        if (nlind < 1) {
            // bad format
            throw new BadAuthorizationHeaderFormatException();
        }

        AuthorizationMethod method = AuthorizationMethod.parse(authorizationStr.substring(0, nlind - 1));

        // Split credentials by ','
        String credentials = authorizationStr.substring(nlind);
        String[] credentialsArr = credentials.split(", ");
        if (credentialsArr.length != 3) {
            throw new BadAuthorizationHeaderFormatException("Credentials does not have correct format.");
        }

        // parse credential
        CredentialScope credentialScope = CredentialScope.parse(credentialsArr[0]);

        // parse signed headers
        if (!credentialsArr[1].startsWith(SIGNEDHEADERS_PREFIX)) {
            throw new BadCredentialFormatException("Bad credentials format: " + credentials);
        }

        String[] headers = credentialsArr[1].substring(SIGNEDHEADERS_PREFIX.length()).split(";");

        // parse signature
        if (!credentialsArr[2].startsWith(SIGNATURE_PREFIX)) {
            throw new BadCredentialFormatException("Bad credentials format: " + credentials);
        }

        String signatureHex = credentialsArr[2].substring(SIGNATURE_PREFIX.length());

//        signature = AuthenticationUtil.fromHexString(signatureHex);
//        byte[] signature = Base64.getDecoder().decode(encodedSig);

        // create AuthorizationInfo
        return new AuthorizationInfo(method, credentialScope, Arrays.asList(headers), signatureHex);
    }

    public AuthorizationMethod getMethod() {
        return this.method;
    }

    public CredentialScope getCredentialScope() {
        return this.credentialScope;
    }

    public byte[] getSignature() {
        return FormattingUtil.fromHexString(this.signatureHex);
    }

    /**
     * Authorization header if of the following form:
     * <Algorithm (e.g. RAI01-ED25519-SHA256)> Credential=<CredentialScope>,SignedHeaders=<Headers>,Signature=<Signature>
     */
    public String getAuthorizationHeaderString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.method.getStringForSignature());
        sb.append(" ");

        sb.append("Credential=");
        sb.append(this.credentialScope.getStringForHeader());
        sb.append(", ");

        sb.append("SignedHeaders=");
        sb.append(String.join(";", this.signedHeaders));
        sb.append(", ");

        sb.append("Signature=");
        sb.append(this.signatureHex);

        return sb.toString();
    }
}
