package org.example.lld.taskmanagementsystem.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private String id;
    private String content;
    private User author;
    private LocalDateTime timestamp;

    public Comment(String content, User author) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
