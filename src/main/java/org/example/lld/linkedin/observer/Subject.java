package org.example.lld.linkedin.observer;

import org.example.lld.linkedin.entity.Notification;

public interface Subject {
    void addObserver(NotificationObserver observer);
    void removeObserver(NotificationObserver observer);
    void notifyObservers(Notification notification);
}
