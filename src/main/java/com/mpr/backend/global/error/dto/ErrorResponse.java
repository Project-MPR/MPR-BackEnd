package com.mpr.backend.global.error.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final Integer status;
    private final String message;
    private final String code;

    @Builder
    public ErrorResponse(Integer status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
