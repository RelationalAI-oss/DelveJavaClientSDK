package com.relationalai.util.auth;

public class CredentialScope
{
    final String accessKey;
    final String date;
    final String region;
    final String service;
    final String terminationString;

    final static String TERMINATION_STRING = "rai01_request";

    /**
     * Expected format of the credential string:
     * <AccessKey>/<YYYYMMDD>/<region>/<service>/rai01_request
     */
    public static CredentialScope parse (String s) throws BadCredentialFormatException
    {
        if ( !s.startsWith(AuthorizationInfo.CREDENTIAL_PREFIX))
        {
            throw new BadCredentialFormatException("Credential is expected to begin with \"" + AuthorizationInfo.CREDENTIAL_PREFIX + "\"");
        }

        String[] credentialArr = s.substring(AuthorizationInfo.CREDENTIAL_PREFIX.length()).split("/");
        if ( credentialArr.length != 5 )
        {
            throw new BadCredentialFormatException("Credential format is invalid: " + s);
        }

        if ( !credentialArr[4].equals(TERMINATION_STRING))
        {
            throw new BadCredentialFormatException("Termination string invalid: " + credentialArr[4]);
        }

        return new CredentialScope(credentialArr);
    }

    public CredentialScope(String[] credentialArr)
    {
        this.accessKey = credentialArr[0];
        this.date = credentialArr[1];
        this.region = credentialArr[2];
        this.service = credentialArr[3];
        this.terminationString = credentialArr[4];
    }

    public CredentialScope(String accessKey, String date, String region, String service)
    {
        this.accessKey = accessKey;
        this.date = date;
        this.region = region;
        this.service = service;
        this.terminationString = TERMINATION_STRING;
    }

    public CredentialScope(String accessKey, String date, String region, String service, String terminationString)
    {
        this.accessKey = accessKey;
        this.date = date;
        this.region = region;
        this.service = service;
        this.terminationString = terminationString;
    }

    public String getStringForSignature()
    {
        return this.date + "/" + this.region + "/" + this.service + "/" + this.terminationString;
    }

    public String getStringForHeader()
    {
        return this.accessKey + "/" + this.date + "/" + this.region + "/" + this.service + "/" + this.terminationString;
    }

    public String getAccessKey()
    {
        return this.accessKey;
    }
}
