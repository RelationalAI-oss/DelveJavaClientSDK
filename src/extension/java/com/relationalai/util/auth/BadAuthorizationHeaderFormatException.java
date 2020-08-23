package com.relationalai.util.auth;

public class BadAuthorizationHeaderFormatException extends Exception {

    public BadAuthorizationHeaderFormatException()
    {
        super("Authorization header does not have the expected format");
    }

    public BadAuthorizationHeaderFormatException(String s)
    {
        super("Authorization header does not have the expected format: " + s);
    }
}
