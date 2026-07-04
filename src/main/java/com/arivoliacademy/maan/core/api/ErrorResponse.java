package com.arivoliacademy.maan.core.api;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * Standard API error response.
 */
public record ErrorResponse(
        int status,
        String error,
        String message,
        String code,
        List<FieldErrorDetail> fieldErrors,
        Instant timestamp
) {

    public ErrorResponse {
        fieldErrors = fieldErrors == null ? List.of() : List.copyOf(fieldErrors);
        Objects.requireNonNull(timestamp, "timestamp must not be null");
    }

    public static ErrorResponse of(int status, String error, String message, String code) {
        return new ErrorResponse(status, error, message, code, List.of(), Instant.now());
    }

    public static ErrorResponse of(int status, String error, String message, String code,
                                   List<FieldErrorDetail> fieldErrors) {
        return new ErrorResponse(status, error, message, code, fieldErrors, Instant.now());
    }
}
