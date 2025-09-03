package org.example.lld.taskmanagementsystem.model;

import java.time.LocalDateTime;

public class ActivityLog {
    private String description;
    private LocalDateTime timestamp;

    public ActivityLog(String description) {
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
