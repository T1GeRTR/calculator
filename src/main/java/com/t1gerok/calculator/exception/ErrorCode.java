package com.t1gerok.calculator.exception;

public enum ErrorCode {
    CANT_GET_USER_BY_SESSION("sessionId", "Can't get user by sessionId"),
    CANT_LOGOUT("sessionId", "Can't logout"),
    CANT_LOGIN("login", "User with login %s not found"),
    DUPLICATE_LOGIN("login", "Login %s already exists"),
    INTERNAL_SERVER_ERROR("internal error", "Internal server error 500"),
    MISSING_REQUEST_PARAM("request parameters", "%s"),
    WRONG_ARGUMENT_TYPE("argument type", "%s"),
    MISSING_COOKIE("cookie", "Missing request cookie, try again"),
    WRONG_PASSWORD("password", "Wrong password"),
    DATABASE_ERROR("query", "Database error"),
    REST_CLIENT_EXCEPTION("cookie", "%s"),
    HTTP_MESSAGE_NOT_READBLE("parameters", "Incorrect parameters");

    private final String field;
    private String message;

    ErrorCode(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public void formatMessage(String string1) {
        message = String.format(message, string1);
    }

    public void formatMessage(int int1) {
        message = String.format(message, int1);
    }

}
