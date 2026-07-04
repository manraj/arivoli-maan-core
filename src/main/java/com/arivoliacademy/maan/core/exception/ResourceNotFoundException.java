package com.arivoliacademy.maan.core.exception;

import com.arivoliacademy.maan.core.constants.MaanConstants;

/**
 * Exception when a requested resource is not found (HTTP 404).
 */
public class ResourceNotFoundException extends MaanException {

    public ResourceNotFoundException(String message) {
        super(message, MaanConstants.ERROR_NOT_FOUND, 404);
    }

    public ResourceNotFoundException(String message, String errorCode) {
        super(message, errorCode, 404);
    }

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(
                "%s not found with identifier: %s".formatted(resourceName, identifier),
                MaanConstants.ERROR_NOT_FOUND,
                404
        );
    }
}
