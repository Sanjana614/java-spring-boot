package org.example.lld.pubsubsystem.enitity;

import java.util.UUID;

public class Message {
    private final String id;
    private final String payload;

    public Message(String payload) {
        this.id = UUID.randomUUID().toString();
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
