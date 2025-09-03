package org.example.lld.linkedin.entity;

import org.example.lld.linkedin.enums.ConnectionStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Connection {
    private String id;
    private final Member requestedBy;
    private final Member requestedTo;
    private ConnectionStatus status;
    private final LocalDateTime requestedAt;
    private LocalDateTime respondedAt;

    public Connection(Member requestedBy, Member requestedTo) {
        this.id = UUID.randomUUID().toString();
        this.requestedBy = requestedBy;
        this.requestedTo = requestedTo;
        this.requestedAt = LocalDateTime.now();
        this.status = ConnectionStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public Member getRequestedBy() {
        return requestedBy;
    }

    public Member getRequestedTo() {
        return requestedTo;
    }

    public ConnectionStatus getStatus() {
        return status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public LocalDateTime getRespondedAt() {
        return respondedAt;
    }

    public void setStatus(ConnectionStatus status) {
        this.status = status;
    }

    public void setRespondedAt(LocalDateTime respondedAt) {
        this.respondedAt = respondedAt;
    }
}
