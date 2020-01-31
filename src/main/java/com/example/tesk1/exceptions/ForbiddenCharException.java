package com.example.tesk1.exceptions;

public class ForbiddenCharException extends RuntimeException {
    private String message;
    private String code;


    public ForbiddenCharException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
