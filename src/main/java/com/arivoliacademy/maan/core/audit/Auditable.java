package com.arivoliacademy.maan.core.audit;

/**
 * Marks a type as carrying audit metadata.
 *
 * <p>Implementations should use the standard audit field names:
 * {@code createdBy}, {@code createdAt}, {@code updatedBy}, {@code updatedAt},
 * {@code deletedBy}, {@code deletedAt}.
 */
public interface Auditable {

    AuditInfo getAuditInfo();

    void setAuditInfo(AuditInfo auditInfo);
}
