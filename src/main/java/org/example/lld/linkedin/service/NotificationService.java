package org.example.lld.linkedin.service;

import org.example.lld.linkedin.entity.Member;
import org.example.lld.linkedin.entity.Notification;

public class NotificationService {
    public void sendNotification(Member member, Notification notification) {
        member.update(notification);
    }
}
