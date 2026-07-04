package com.arivoliacademy.maan.core.exception;

import com.arivoliacademy.maan.core.constants.MaanConstants;

/**
 * Exception for resource conflicts such as duplicate entries (HTTP 409).
 */
public class ConflictException extends MaanException {

    public ConflictException(String message) {
        super(message, MaanConstants.ERROR_CONFLICT, 409);
    }

    public ConflictException(String message, String errorCode) {
        super(message, errorCode, 409);
    }
}
