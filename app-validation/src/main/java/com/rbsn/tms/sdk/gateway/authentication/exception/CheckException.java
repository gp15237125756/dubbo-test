package com.rbsn.tms.sdk.gateway.authentication.exception;

public class CheckException extends RuntimeException{

    private static final long serialVersionUID = 6391862119761169622L;

    private String errorMessage;

    public CheckException() {
        super();
    }

    public CheckException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message,Throwable e) {
        super(message,e);
    }

    @Override
    public String toString() {
        return "CheckException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
