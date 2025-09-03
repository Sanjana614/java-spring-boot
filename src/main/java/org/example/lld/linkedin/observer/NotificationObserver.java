package org.example.lld.linkedin.observer;

import org.example.lld.linkedin.entity.Notification;

public interface NotificationObserver {
    void update(Notification notification);
}
