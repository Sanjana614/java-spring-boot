package org.example.lld.linkedin.entity.content;

import org.example.lld.linkedin.entity.Member;

import java.time.LocalDateTime;

public abstract class AuditMetadata {
    protected final Member createdBy;
    protected final LocalDateTime createdAt;

    public AuditMetadata(Member createdBy) {
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    public Member getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
