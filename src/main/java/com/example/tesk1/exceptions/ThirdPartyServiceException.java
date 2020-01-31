package com.example.tesk1.exceptions;

import java.util.stream.IntStream;

public class ThirdPartyServiceException extends RuntimeException {

    private Integer httpCode;
    private String message;

    public ThirdPartyServiceException(String message, Integer httpCode) {
        super(message);
        this.httpCode = httpCode;
        this.message = message;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
