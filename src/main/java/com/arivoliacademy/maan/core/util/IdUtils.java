package com.arivoliacademy.maan.core.util;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Identifier generation and validation utilities.
 */
public final class IdUtils {

    private static final Pattern UUID_PATTERN = Pattern.compile(
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$"
    );
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final char[] ALPHANUMERIC =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    private IdUtils() {
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidUuid(String value) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return UUID_PATTERN.matcher(value).matches();
    }

    public static UUID parseUuid(String value) {
        if (!isValidUuid(value)) {
            throw new IllegalArgumentException("Invalid UUID: " + value);
        }
        return UUID.fromString(value);
    }

    public static String generateShortId(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length must be positive");
        }
        char[] buffer = new char[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = ALPHANUMERIC[SECURE_RANDOM.nextInt(ALPHANUMERIC.length)];
        }
        return new String(buffer);
    }
}
