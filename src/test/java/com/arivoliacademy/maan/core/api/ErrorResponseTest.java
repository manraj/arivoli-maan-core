package com.arivoliacademy.maan.core.api;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorResponseTest {

    @Test
    void ofCreatesErrorResponseWithoutFieldErrors() {
        ErrorResponse response = ErrorResponse.of(400, "Bad Request", "Invalid input", "MAAN-400");

        assertThat(response.status()).isEqualTo(400);
        assertThat(response.error()).isEqualTo("Bad Request");
        assertThat(response.message()).isEqualTo("Invalid input");
        assertThat(response.code()).isEqualTo("MAAN-400");
        assertThat(response.fieldErrors()).isEmpty();
        assertThat(response.timestamp()).isNotNull();
    }

    @Test
    void ofCreatesErrorResponseWithFieldErrors() {
        List<FieldErrorDetail> fieldErrors = List.of(new FieldErrorDetail("email", "must be valid", "bad@"));

        ErrorResponse response = ErrorResponse.of(400, "Bad Request", "Validation failed", "MAAN-400", fieldErrors);

        assertThat(response.fieldErrors()).hasSize(1);
        assertThat(response.fieldErrors().getFirst().field()).isEqualTo("email");
    }
}
