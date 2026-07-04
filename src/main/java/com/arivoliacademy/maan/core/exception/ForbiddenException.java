package com.arivoliacademy.maan.core.exception;

import com.arivoliacademy.maan.core.constants.MaanConstants;

/**
 * Exception for authenticated but forbidden access (HTTP 403).
 */
public class ForbiddenException extends MaanException {

    public ForbiddenException(String message) {
        super(message, MaanConstants.ERROR_FORBIDDEN, 403);
    }

    public ForbiddenException(String message, String errorCode) {
        super(message, errorCode, 403);
    }
}
