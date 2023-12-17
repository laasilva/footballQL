package com.football.ql.core.exception;

import org.springframework.http.HttpStatus;
import com.football.ql.core.exception.model.Error;

public class CoreException extends RuntimeException {
    private final Error error;

    public CoreException(HttpStatus status, String message) {
        super();
        this.error = new Error(status, message);
    }

    public Error getErrorMessage() {
        return error;
    }
}