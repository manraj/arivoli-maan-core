package com.arivoliacademy.maan.core.audit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuditInfoTest {

    @Test
    void createdInitializesAuditFields() {
        AuditInfo auditInfo = AuditInfo.created("user-1");

        assertThat(auditInfo.createdBy()).isEqualTo("user-1");
        assertThat(auditInfo.updatedBy()).isEqualTo("user-1");
        assertThat(auditInfo.createdAt()).isNotNull();
        assertThat(auditInfo.updatedAt()).isEqualTo(auditInfo.createdAt());
    }

    @Test
    void withUpdatedUpdatesModifierAndTimestamp() throws InterruptedException {
        AuditInfo created = AuditInfo.created("user-1");
        Thread.sleep(2);
        AuditInfo updated = created.withUpdated("user-2");

        assertThat(updated.createdBy()).isEqualTo("user-1");
        assertThat(updated.updatedBy()).isEqualTo("user-2");
        assertThat(updated.updatedAt()).isAfter(created.updatedAt());
    }
}
