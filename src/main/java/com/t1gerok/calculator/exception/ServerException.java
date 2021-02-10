package com.t1gerok.calculator.exception;

public class ServerException extends Exception {

    private final ErrorCode errorcode;


    public ServerException(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }

    public ServerException(ErrorCode errorcode, String string1) {
        this.errorcode = errorcode;
        errorcode.formatMessage(string1);
    }

    public ServerException(ErrorCode errorcode, int int1) {
        this.errorcode = errorcode;
        errorcode.formatMessage(int1);
    }

    public ErrorCode getErrorCode() {
        return errorcode;
    }
}
