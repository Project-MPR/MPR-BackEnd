package com.mpr.backend.global.error;

public class NoStationException extends RuntimeException{
    public NoStationException(String message) {
        super(message);
    }

    public NoStationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStationException(Throwable cause) {
        super(cause);
    }

    protected NoStationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
