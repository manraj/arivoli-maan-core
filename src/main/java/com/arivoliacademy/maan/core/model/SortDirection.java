package com.arivoliacademy.maan.core.model;

/**
 * Sort direction for list and query operations.
 */
public enum SortDirection {
    ASC,
    DESC;

    public static SortDirection fromString(String value) {
        if (value == null || value.isBlank()) {
            return ASC;
        }
        return SortDirection.valueOf(value.trim().toUpperCase());
    }

    public boolean isAscending() {
        return this == ASC;
    }
}
