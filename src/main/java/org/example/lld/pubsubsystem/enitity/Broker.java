package org.example.lld.pubsubsystem.enitity;

import org.example.lld.pubsubsystem.subscriber.Subscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Broker {
    private static Broker instance;
    private final Map<String, Topic> topicRegistry = new HashMap<>();
    private final ExecutorService executorService;

    public Broker() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public static Broker getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Broker.class) {
                if (Objects.isNull(instance)) {
                    instance = new Broker();
                }
            }
        }
        return instance;
    }

    public void addTopic(String topicName) {
        topicRegistry.put(topicName, new Topic(topicName, executorService));
    }

    public void addSubscriber(String topicName, List<Subscriber> subscribers) {
        Topic topic = topicRegistry.get(topicName);
        if (Objects.isNull(topic)) {
            System.out.println("No topic found with name: " + topicName);
            return;
        }
        topic.addSubscriber(subscribers);
    }

    public void publishMessage(String topicName, Message message) {
        Topic topic = topicRegistry.get(topicName);
        if (Objects.isNull(topic)) {
            System.out.println("No topic found with name: " + topicName);
            return;
        }
        topic.broadCast(message);
    }

    public void unsubscribe(String topicName, Subscriber subscriber) {
        Topic topic = topicRegistry.get(topicName);
        topic.unsubscribe(subscriber);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            boolean terminated = executorService.awaitTermination(5, TimeUnit.SECONDS);
            if (!terminated) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            System.out.println("Executor service terminated successfully!");
        } catch (InterruptedException e) {
            System.out.println("Exception occurred while terminating executorService.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
