package org.example.lld.linkedin.entity;

import org.example.lld.linkedin.enums.NotificationType;

import java.util.UUID;

public class Notification {
    private final String id;
    private final String title;
    private final String content;
    private final String userNotified;
    private final NotificationType type;
    private boolean isRead = false;

    public Notification(String title, String content, String userNotified, NotificationType type) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.userNotified = userNotified;
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserNotified() {
        return this.userNotified;
    }

    public NotificationType getType() {
        return this.type;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void markRead() {
        this.isRead = true;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userNotified='" + userNotified + '\'' +
                ", type=" + type +
                ", isRead=" + isRead +
                '}';
    }
}
