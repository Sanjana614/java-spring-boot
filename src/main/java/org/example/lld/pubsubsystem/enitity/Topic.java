package org.example.lld.pubsubsystem.enitity;

import org.example.lld.pubsubsystem.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Topic {
    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final ExecutorService executorService;

    public Topic(String name, ExecutorService executorService) {
        this.name = name;
        this.executorService = executorService;
    }

    public void addSubscriber(List<Subscriber> subscribers) {
        this.subscribers.addAll(subscribers);
    }

    public String getName() {
        return name;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void broadCast(Message message) {
        this.subscribers.forEach(subscriber ->
                executorService.submit(() -> subscriber.onMessage(message))
        );
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
}
