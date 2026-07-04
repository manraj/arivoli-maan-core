package com.arivoliacademy.maan.core.api;

/**
 * Result of an operation that may succeed or fail without throwing an exception.
 *
 * @param <T> payload type on success
 */
public record OperationResult<T>(
        boolean success,
        T data,
        String message,
        String errorCode
) {

    public static <T> OperationResult<T> success(T data) {
        return new OperationResult<>(true, data, null, null);
    }

    public static <T> OperationResult<T> success(T data, String message) {
        return new OperationResult<>(true, data, message, null);
    }

    public static <T> OperationResult<T> failure(String message) {
        return failure(null, message);
    }

    public static <T> OperationResult<T> failure(String errorCode, String message) {
        return new OperationResult<>(false, null, message, errorCode);
    }
}
