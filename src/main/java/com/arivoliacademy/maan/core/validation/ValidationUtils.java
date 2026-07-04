package com.arivoliacademy.maan.core.validation;

import com.arivoliacademy.maan.core.util.StringUtils;

import java.util.regex.Pattern;

/**
 * Common validation helpers for request and domain data.
 */
public final class ValidationUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{7,15}$");

    private ValidationUtils() {
    }

    public static void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
    }

    public static void requireNonBlank(String value, String fieldName) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
    }

    public static boolean isValidEmail(String email) {
        return StringUtils.isNotBlank(email) && EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean isValidPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        String normalized = phone.replaceAll("[\\s()-]", "");
        return PHONE_PATTERN.matcher(normalized).matches();
    }

    public static void requireLength(String value, int min, int max, String fieldName) {
        requireNonBlank(value, fieldName);
        int length = value.trim().length();
        if (length < min || length > max) {
            throw new IllegalArgumentException(
                    "%s length must be between %d and %d".formatted(fieldName, min, max)
            );
        }
    }

    public static void requireInRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                    "%s must be between %d and %d".formatted(fieldName, min, max)
            );
        }
    }
}
