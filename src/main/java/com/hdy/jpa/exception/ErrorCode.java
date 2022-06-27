package com.hdy.jpa.exception;

public enum ErrorCode {
    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    TOKEN_EXPIRATION(410, "C001", "Token Was Expired"),
    USER_NOT_FOUND(404, "C002", "User Not Found");

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
