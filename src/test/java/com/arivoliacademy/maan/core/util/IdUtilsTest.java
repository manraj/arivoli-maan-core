package com.arivoliacademy.maan.core.util;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IdUtilsTest {

    @Test
    void generateUuidReturnsValidUuid() {
        String uuid = IdUtils.generateUuid();

        assertThat(IdUtils.isValidUuid(uuid)).isTrue();
    }

    @Test
    void parseUuidReturnsUuidForValidValue() {
        UUID uuid = UUID.randomUUID();

        assertThat(IdUtils.parseUuid(uuid.toString())).isEqualTo(uuid);
    }

    @Test
    void parseUuidThrowsForInvalidValue() {
        assertThatThrownBy(() -> IdUtils.parseUuid("not-a-uuid"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateShortIdReturnsRequestedLength() {
        assertThat(IdUtils.generateShortId(12)).hasSize(12);
    }
}
