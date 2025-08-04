package org.example.lld.stackoverflow;

import java.time.LocalDateTime;

public abstract class CreationInfo {

    protected String id;
    protected User createdBy;
    protected LocalDateTime createdOn;

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public User getAuthor() {
        return createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
