package com.arivoliacademy.maan.core.api;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApiResponseTest {

    @Test
    void successCreatesSuccessfulResponse() {
        ApiResponse<String> response = ApiResponse.success("created", "item-1");

        assertThat(response.success()).isTrue();
        assertThat(response.message()).isEqualTo("created");
        assertThat(response.data()).isEqualTo("item-1");
        assertThat(response.timestamp()).isNotNull();
    }

    @Test
    void failureCreatesUnsuccessfulResponse() {
        ApiResponse<Void> response = ApiResponse.failure("invalid request");

        assertThat(response.success()).isFalse();
        assertThat(response.message()).isEqualTo("invalid request");
        assertThat(response.data()).isNull();
    }
}
