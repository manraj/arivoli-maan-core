package com.arivoliacademy.maan.core.api;

/**
 * Describes a validation error for a single request field.
 */
public record FieldErrorDetail(
        String field,
        String message,
        Object rejectedValue
) {
}
