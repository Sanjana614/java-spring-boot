package org.example.lld.linkedin.entity.content;

import org.example.lld.linkedin.entity.Member;

import java.util.UUID;

public class Comment extends AuditMetadata {
    private final String id;
    private String content;

    public Comment(Member createdBy, String content) {
        super(createdBy);
        this.id = UUID.randomUUID().toString();
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
