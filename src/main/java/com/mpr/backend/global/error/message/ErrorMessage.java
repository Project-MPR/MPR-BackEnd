package com.mpr.backend.global.error.message;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {
    NO_STATION_ERROR("There is a no station information", HttpStatus.BAD_REQUEST.value());

    private final String message;
    private final Integer status;

    ErrorMessage(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
