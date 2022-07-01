package com.mpr.backend.global.error.handler;

import com.mpr.backend.global.error.NoStationException;
import com.mpr.backend.global.error.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = {NoStationException.class})
    public ResponseEntity<ErrorResponse> noStationException(NoStationException e) {
        ErrorResponse res = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .code("").build();
        log.info("error : there is a no station");
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
