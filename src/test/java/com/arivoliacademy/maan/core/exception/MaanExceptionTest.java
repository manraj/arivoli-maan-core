package com.arivoliacademy.maan.core.exception;

import com.arivoliacademy.maan.core.constants.MaanConstants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaanExceptionTest {

    @Test
    void resourceNotFoundUsesDefaultErrorCode() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Course", 10);

        assertThat(ex.getMessage()).contains("Course");
        assertThat(ex.getErrorCode()).isEqualTo(MaanConstants.ERROR_NOT_FOUND);
        assertThat(ex.getHttpStatus()).isEqualTo(404);
    }

    @Test
    void badRequestUses400Status() {
        BadRequestException ex = new BadRequestException("invalid payload");

        assertThat(ex.getHttpStatus()).isEqualTo(400);
        assertThat(ex.getErrorCode()).isEqualTo(MaanConstants.ERROR_BAD_REQUEST);
    }

    @Test
    void conflictUses409Status() {
        ConflictException ex = new ConflictException("already exists");

        assertThat(ex.getHttpStatus()).isEqualTo(409);
    }

    @Test
    void unauthorizedUses401Status() {
        UnauthorizedException ex = new UnauthorizedException("missing token");

        assertThat(ex.getHttpStatus()).isEqualTo(401);
    }

    @Test
    void forbiddenUses403Status() {
        ForbiddenException ex = new ForbiddenException("insufficient permissions");

        assertThat(ex.getHttpStatus()).isEqualTo(403);
    }
}
