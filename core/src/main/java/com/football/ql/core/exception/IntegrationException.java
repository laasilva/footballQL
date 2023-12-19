package com.football.ql.core.exception;

import org.springframework.http.HttpStatus;

import com.football.ql.core.exception.model.Error;
import org.springframework.web.client.HttpClientErrorException;

public class IntegrationException extends HttpClientErrorException {
    private final Error error;

    public IntegrationException(HttpStatus status, String message) {
        super(status, message);
        this.error = new Error(status, message);
    }

    public IntegrationException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
        this.error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public Error getErrorMessage() {
        return error;
    }
}
