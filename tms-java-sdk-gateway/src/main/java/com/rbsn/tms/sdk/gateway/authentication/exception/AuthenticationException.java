package com.rbsn.tms.sdk.gateway.authentication.exception;

public class AuthenticationException extends RuntimeException{

    private static final long serialVersionUID = 6391862119761169622L;

    private String errorMessage;

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    public AuthenticationException(String message, Throwable e) {
        super(message,e);
    }

    @Override
    public String toString() {
        return "AuthenticationException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
