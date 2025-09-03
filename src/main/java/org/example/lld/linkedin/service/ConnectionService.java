package org.example.lld.linkedin.service;

import org.example.lld.linkedin.entity.Connection;
import org.example.lld.linkedin.entity.Member;
import org.example.lld.linkedin.entity.Notification;
import org.example.lld.linkedin.enums.ConnectionResponseType;
import org.example.lld.linkedin.enums.ConnectionStatus;
import org.example.lld.linkedin.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectionService {

    private final Map<String, Connection> connectionMap;
    private final NotificationService notificationService;

    public ConnectionService() {
        this.connectionMap = new HashMap<>();
        this.notificationService = new NotificationService();
    }

    public String sendConnectionRequest(Member from, Member to) {
        Connection connection = new Connection(from, to);
        connectionMap.put(connection.getId(), connection);
        notificationService.sendNotification(to, getConnectionRequest(from, to));
        return connection.getId();
    }

    public void respondConnectionRequest(String requestId, ConnectionResponseType responseType) {
        Connection connection = connectionMap.get(requestId);
        if (Objects.isNull(connection)) {
            System.out.println("No connection found with requestId: " + requestId);
            return;
        }
        switch (responseType) {
            case ACCEPT:
                Member fromUser = connection.getRequestedBy();
                Member toUser = connection.getRequestedTo();
                fromUser.addConnection(toUser);
                toUser.addConnection(fromUser);
                connection.setStatus(ConnectionStatus.ACCEPTED);
                connection.setRespondedAt(LocalDateTime.now());
                notificationService.sendNotification(fromUser, getConnectionAcceptedNotification(toUser, fromUser));
                break;
            case REJECT:
                connection.setStatus(ConnectionStatus.REJECTED);
                connection.setRespondedAt(LocalDateTime.now());
                break;
            default:
                System.out.println("Invalid responseType.");
        }
    }

    private static Notification getConnectionRequest(Member from, Member to) {
        return new Notification(
                "Connection request",
                "You have got connection request from: " + from.getName(),
                to.getId(),
                NotificationType.CONNECTION_REQUEST
        );
    }

    private static Notification getConnectionAcceptedNotification(Member toUser, Member fromUser) {
        return new Notification(
                "Connection Accepted",
                toUser.getName() + " has accepted your request.",
                fromUser.getId(),
                NotificationType.CONNECTION_REQUEST_ACCEPTED
        );
    }
}
