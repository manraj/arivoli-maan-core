package com.arivoliacademy.maan.core.util;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * String utility methods for common text operations.
 */
public final class StringUtils {

    private static final Pattern WHITESPACE = Pattern.compile("\\s+");
    private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^a-zA-Z0-9]+");

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    public static String trimToEmpty(String value) {
        return value == null ? "" : value.trim();
    }

    public static String defaultIfBlank(String value, String defaultValue) {
        return isBlank(value) ? defaultValue : value;
    }

    public static String normalizeWhitespace(String value) {
        if (value == null) {
            return null;
        }
        return WHITESPACE.matcher(value.trim()).replaceAll(" ");
    }

    public static String toSlug(String value) {
        if (isBlank(value)) {
            return "";
        }
        String normalized = NON_ALPHANUMERIC.matcher(value.trim().toLowerCase(Locale.ROOT)).replaceAll("-");
        return normalized.replaceAll("^-+|-+$", "");
    }

    public static String truncate(String value, int maxLength) {
        if (value == null || maxLength < 0) {
            return value;
        }
        if (value.length() <= maxLength) {
            return value;
        }
        return value.substring(0, maxLength);
    }
}
