package com.arivoliacademy.maan.core.constants;

/**
 * Shared constants for Maan framework consumers.
 */
public final class MaanConstants {

    public static final String ERROR_BAD_REQUEST = "MAAN-400";
    public static final String ERROR_UNAUTHORIZED = "MAAN-401";
    public static final String ERROR_FORBIDDEN = "MAAN-403";
    public static final String ERROR_NOT_FOUND = "MAAN-404";
    public static final String ERROR_CONFLICT = "MAAN-409";

    public static final String HEADER_REQUEST_ID = "X-Request-Id";
    public static final String HEADER_CORRELATION_ID = "X-Correlation-Id";

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    private MaanConstants() {
    }
}
