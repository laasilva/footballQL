package com.football.ql.core.exception.model;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    SYNC_ERROR(HttpStatus.UNPROCESSABLE_ENTITY, "Error while syncing league from Football-Data."),
    INVALID_LEAGUE_CODE(HttpStatus.BAD_REQUEST, "Requested Competition code does not exist."),
    INVALID_TEAM_NAME(HttpStatus.BAD_REQUEST, "Requested Team does not exist."),
    INVALID_PLAYER_NAME(HttpStatus.BAD_REQUEST, "Requested Player does not exist."),
    PERSIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Error while saving synced information.");

    private final HttpStatus code;
    private final String message;

    ErrorMessage(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}