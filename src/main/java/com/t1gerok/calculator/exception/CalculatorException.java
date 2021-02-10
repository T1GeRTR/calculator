package com.t1gerok.calculator.exception;

public class CalculatorException extends Exception {

    private final ErrorCode errorcode;


    public CalculatorException(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }

    public CalculatorException(ErrorCode errorcode, String string1) {
        this.errorcode = errorcode;
        errorcode.formatMessage(string1);
    }

    public CalculatorException(ErrorCode errorcode, int int1) {
        this.errorcode = errorcode;
        errorcode.formatMessage(int1);
    }

    public ErrorCode getErrorCode() {
        return errorcode;
    }
}
