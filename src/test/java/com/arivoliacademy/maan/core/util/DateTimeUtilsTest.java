package com.arivoliacademy.maan.core.util;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class DateTimeUtilsTest {

    @Test
    void formatAndParseInstantRoundTrip() {
        Instant instant = Instant.parse("2026-01-15T10:30:00.123Z");

        String formatted = DateTimeUtils.formatInstant(instant);
        Optional<Instant> parsed = DateTimeUtils.parseInstant(instant.toString());

        assertThat(formatted).isNotBlank();
        assertThat(parsed).contains(instant);
    }

    @Test
    void formatAndParseDate() {
        LocalDate date = LocalDate.of(2026, 1, 15);

        assertThat(DateTimeUtils.formatDate(date)).isEqualTo("2026-01-15");
        assertThat(DateTimeUtils.parseDate("2026-01-15")).contains(date);
    }

    @Test
    void toInstantConvertsLocalDateTimeUsingUtc() {
        LocalDateTime localDateTime = LocalDateTime.of(2026, 1, 15, 10, 30, 0);

        Instant instant = DateTimeUtils.toInstant(localDateTime);

        assertThat(instant).isEqualTo(localDateTime.toInstant(java.time.ZoneOffset.UTC));
    }
}
