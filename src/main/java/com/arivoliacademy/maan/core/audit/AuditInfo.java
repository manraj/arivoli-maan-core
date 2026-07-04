package com.arivoliacademy.maan.core.audit;

import java.time.Instant;

/**
 * Audit metadata for create and update operations.
 *
 * <p>Standard audit field names used across Maan framework modules:
 * {@code createdBy}, {@code createdAt}, {@code updatedBy}, {@code updatedAt},
 * {@code deletedBy}, {@code deletedAt}.
 *
 * @param createdBy user or system that created the record
 * @param createdAt timestamp when the record was created
 * @param updatedBy user or system that last updated the record
 * @param updatedAt timestamp when the record was last updated
 */
public record AuditInfo(
        String createdBy,
        Instant createdAt,
        String updatedBy,
        Instant updatedAt
) {

    /**
     * Creates audit metadata for a newly created record.
     */
    public static AuditInfo created(String createdBy) {
        Instant now = Instant.now();
        return new AuditInfo(createdBy, now, createdBy, now);
    }

    /**
     * Returns a copy with updated audit fields while preserving creation metadata.
     */
    public AuditInfo withUpdated(String updatedBy) {
        return new AuditInfo(createdBy, createdAt, updatedBy, Instant.now());
    }
}
