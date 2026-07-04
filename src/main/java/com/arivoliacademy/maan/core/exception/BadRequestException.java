package com.arivoliacademy.maan.core.exception;

import com.arivoliacademy.maan.core.constants.MaanConstants;

/**
 * Exception for invalid client requests (HTTP 400).
 */
public class BadRequestException extends MaanException {

    public BadRequestException(String message) {
        super(message, MaanConstants.ERROR_BAD_REQUEST, 400);
    }

    public BadRequestException(String message, String errorCode) {
        super(message, errorCode, 400);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, MaanConstants.ERROR_BAD_REQUEST, 400, cause);
    }
}
