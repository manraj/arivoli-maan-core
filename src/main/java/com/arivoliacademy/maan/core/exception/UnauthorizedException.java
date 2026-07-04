package com.arivoliacademy.maan.core.exception;

import com.arivoliacademy.maan.core.constants.MaanConstants;

/**
 * Exception for unauthenticated access (HTTP 401).
 */
public class UnauthorizedException extends MaanException {

    public UnauthorizedException(String message) {
        super(message, MaanConstants.ERROR_UNAUTHORIZED, 401);
    }

    public UnauthorizedException(String message, String errorCode) {
        super(message, errorCode, 401);
    }
}
