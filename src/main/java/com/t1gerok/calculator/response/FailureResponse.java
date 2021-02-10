package com.t1gerok.calculator.response;


import com.t1gerok.calculator.exception.CalculatorException;
import com.t1gerok.calculator.exception.ErrorCode;

public class FailureResponse {
    private ErrorCode errorCode;
    private String field;
    private String message;

    public FailureResponse(CalculatorException ex) {
        this.errorCode = ex.getErrorCode();
        this.field = ex.getErrorCode().getField();
        this.message = ex.getErrorCode().getMessage();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
