package com.relationalai.util.auth;

public class AuthorizationMethod
{
    public static final String AUTH_VERSION="RAI01";
    public static final String ENCRYPTION_ALGO="ED25519";
    public static final String HASH_ALGO="SHA256";

    public static AuthorizationMethod parse(String s) throws InvalidAuthorizationMethodException
    {
        // e.g. RAI01-ED25519-SHA256
        String[] substrs = s.split("-");
        if ( substrs.length != 3 )
        {
            throw new InvalidAuthorizationMethodException("Authorization method is not valid: " + s);
        }

        String version = substrs[0];
        if ( !version.equals(AUTH_VERSION))
        {
            throw new InvalidAuthorizationMethodException("Authorization version is not valid: " + version);
        }

        String encryptionAlgo = substrs[1];
        if ( !encryptionAlgo.equals(ENCRYPTION_ALGO))
        {
            throw new InvalidAuthorizationMethodException("Authorization encryption algorithm is not valid: " + encryptionAlgo);
        }

        String hashAlgo = substrs[2];
        if ( !hashAlgo.equals(HASH_ALGO))
        {
            throw new InvalidAuthorizationMethodException("Authorization hash algorithm is not valid: " + hashAlgo);
        }

        return new AuthorizationMethod(version, encryptionAlgo, hashAlgo);
    }

    public String getStringForSignature()
    {
        return this.version + "-" + this.encryptionAlgo + "-" + this.hashAlgo;
    }

    public AuthorizationMethod(String version, String encryptionAlgo, String hashAlgo)
    {
        this.version = version;
        this.encryptionAlgo = encryptionAlgo;
        this.hashAlgo = hashAlgo;
    }

    public AuthorizationMethod()
    {
        this.version = AUTH_VERSION;
        this.encryptionAlgo = ENCRYPTION_ALGO;
        this.hashAlgo = HASH_ALGO;
    }

    final String version;
    final String encryptionAlgo;
    final String hashAlgo;
}
