package com.arivoliacademy.maan.core.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SortDirectionTest {

    @Test
    void fromStringParsesCaseInsensitiveValue() {
        assertThat(SortDirection.fromString("desc")).isEqualTo(SortDirection.DESC);
        assertThat(SortDirection.fromString("ASC")).isEqualTo(SortDirection.ASC);
    }

    @Test
    void fromStringDefaultsToAscForBlankValue() {
        assertThat(SortDirection.fromString("")).isEqualTo(SortDirection.ASC);
        assertThat(SortDirection.fromString(null)).isEqualTo(SortDirection.ASC);
    }

    @Test
    void fromStringThrowsForInvalidValue() {
        assertThatThrownBy(() -> SortDirection.fromString("sideways"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
