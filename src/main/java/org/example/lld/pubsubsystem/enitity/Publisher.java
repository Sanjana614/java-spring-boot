package org.example.lld.pubsubsystem.enitity;

public class Publisher {
    private final Broker broker;

    public Publisher(Broker broker) {
        this.broker = broker;
    }

    public void publish(String topicName, Message message) {
        broker.publishMessage(topicName, message);
    }
}
