package com.arivoliacademy.maan.core.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationResultTest {

    @Test
    void successReturnsSuccessfulResult() {
        OperationResult<Integer> result = OperationResult.success(42, "done");

        assertThat(result.success()).isTrue();
        assertThat(result.data()).isEqualTo(42);
        assertThat(result.message()).isEqualTo("done");
        assertThat(result.errorCode()).isNull();
    }

    @Test
    void failureReturnsFailedResult() {
        OperationResult<String> result = OperationResult.failure("MAAN-409", "duplicate");

        assertThat(result.success()).isFalse();
        assertThat(result.data()).isNull();
        assertThat(result.errorCode()).isEqualTo("MAAN-409");
        assertThat(result.message()).isEqualTo("duplicate");
    }
}
