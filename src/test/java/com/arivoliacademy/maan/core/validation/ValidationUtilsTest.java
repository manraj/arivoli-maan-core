package com.arivoliacademy.maan.core.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilsTest {

    @Test
    void requireNonNullThrowsForNullValue() {
        assertThatThrownBy(() -> ValidationUtils.requireNonNull(null, "name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name");
    }

    @Test
    void requireNonBlankThrowsForBlankValue() {
        assertThatThrownBy(() -> ValidationUtils.requireNonBlank("  ", "email"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidEmailAcceptsValidAddress() {
        assertThat(ValidationUtils.isValidEmail("user@example.com")).isTrue();
        assertThat(ValidationUtils.isValidEmail("invalid")).isFalse();
    }

    @Test
    void isValidPhoneAcceptsNormalizedNumber() {
        assertThat(ValidationUtils.isValidPhone("+1 (555) 123-4567")).isTrue();
        assertThat(ValidationUtils.isValidPhone("abc")).isFalse();
    }

    @Test
    void requireLengthValidatesStringBounds() {
        assertThatCode(() -> ValidationUtils.requireLength("hello", 3, 10, "title"))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> ValidationUtils.requireLength("hi", 3, 10, "title"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void requireInRangeValidatesNumericBounds() {
        assertThatCode(() -> ValidationUtils.requireInRange(5, 1, 10, "pageSize"))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> ValidationUtils.requireInRange(20, 1, 10, "pageSize"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
