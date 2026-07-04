package com.arivoliacademy.maan.core.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void isBlankDetectsNullAndWhitespace() {
        assertThat(StringUtils.isBlank(null)).isTrue();
        assertThat(StringUtils.isBlank("  ")).isTrue();
        assertThat(StringUtils.isNotBlank("value")).isTrue();
    }

    @Test
    void trimToNullAndDefaultIfBlank() {
        assertThat(StringUtils.trimToNull("  hello  ")).isEqualTo("hello");
        assertThat(StringUtils.trimToNull("   ")).isNull();
        assertThat(StringUtils.defaultIfBlank(" ", "default")).isEqualTo("default");
    }

    @Test
    void normalizeWhitespaceCollapsesSpaces() {
        assertThat(StringUtils.normalizeWhitespace("  hello   world  ")).isEqualTo("hello world");
    }

    @Test
    void toSlugCreatesUrlFriendlyValue() {
        assertThat(StringUtils.toSlug(" Hello World! ")).isEqualTo("hello-world");
    }

    @Test
    void truncateLimitsLength() {
        assertThat(StringUtils.truncate("abcdef", 3)).isEqualTo("abc");
    }
}
