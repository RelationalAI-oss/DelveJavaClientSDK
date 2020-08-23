package com.relationalai.util.auth;

public class MissingAuthorizationHeaderException extends Exception {

    public MissingAuthorizationHeaderException(String msg) {
        super(msg);
    }

}
