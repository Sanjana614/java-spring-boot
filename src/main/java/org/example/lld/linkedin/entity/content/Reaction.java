package org.example.lld.linkedin.entity.content;

import org.example.lld.linkedin.entity.Member;
import org.example.lld.linkedin.enums.ReactionType;

import java.util.UUID;

public class Reaction extends AuditMetadata {
    private final String id;
    private ReactionType type;

    public Reaction(Member createdBy, ReactionType type) {
        super(createdBy);
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public ReactionType getType() {
        return type;
    }
}
