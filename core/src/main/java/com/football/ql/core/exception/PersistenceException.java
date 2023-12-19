package com.football.ql.core.exception;

import com.football.ql.core.exception.model.Error;
import org.springframework.http.HttpStatus;

public class PersistenceException  extends RuntimeException {
    private final Error error;


    public PersistenceException(HttpStatus status, String message) {
        super(message);
        this.error = new Error(status, message);
    }

    public PersistenceException(String message) {
        super(message);
        this.error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public Error getErrorMessage() {
        return error;
    }
}