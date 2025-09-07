package org.example.lld.pubsubsystem;

import org.example.lld.pubsubsystem.enitity.Broker;
import org.example.lld.pubsubsystem.enitity.Message;
import org.example.lld.pubsubsystem.enitity.Publisher;
import org.example.lld.pubsubsystem.subscriber.AlertSubscriber;
import org.example.lld.pubsubsystem.subscriber.NewsSubscriber;
import org.example.lld.pubsubsystem.subscriber.Subscriber;

import java.util.Arrays;

import static org.example.lld.pubsubsystem.constant.Constants.*;

public class PubSubSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        Broker broker = Broker.getInstance();

        // --- Create Subscribers ---
        Subscriber sportsFan1 = new NewsSubscriber("SportsFan1");
        Subscriber sportsFan2 = new NewsSubscriber("SportsFan2");
        Subscriber techie1 = new NewsSubscriber("Techie1");
        Subscriber allNewsReader = new NewsSubscriber("AllNewsReader");
        Subscriber systemAdmin = new AlertSubscriber("SystemAdmin");

        broker.addTopic(SPORTS_TOPIC);
        broker.addTopic(TECH_TOPIC);
        broker.addTopic(WEATHER_TOPIC);

        broker.addSubscriber(SPORTS_TOPIC, Arrays.asList(sportsFan1, sportsFan2, allNewsReader, systemAdmin));
        broker.addSubscriber(TECH_TOPIC, Arrays.asList(techie1, allNewsReader));

        System.out.println("\n--- Publishing Messages ---");

        Publisher publisher = new Publisher(broker);

        // --- Publish to SPORTS topic ---
        publisher.publish(SPORTS_TOPIC, new Message("Team A wins the championship!"));
        // Expected: SportsFan1, SportsFan2, AllNewsReader, SystemAdmin receive this.

        // --- Publish to TECH topic ---
        publisher.publish(TECH_TOPIC, new Message("New AI model released."));
        // Expected: Techie1, AllNewsReader receive this.

        // --- Publish to WEATHER topic (no subscribers) ---
        publisher.publish(WEATHER_TOPIC, new Message("Sunny with a high of 75°F."));
        // Expected: Message is dropped.

        // Allow some time for async messages to be processed
        Thread.sleep(500);

        System.out.println("\n--- Unsubscribing a user and re-publishing ---");

        // SportsFan2 gets tired of sports news
        broker.unsubscribe(SPORTS_TOPIC, sportsFan2);

        // Publish another message to SPORTS
        publisher.publish(SPORTS_TOPIC, new Message("Major player traded to Team B."));
        // Expected: SportsFan1, AllNewsReader, SystemAdmin receive this. SportsFan2 does NOT.

        // Give messages time to be delivered
        Thread.sleep(500);

        // --- Shutdown the service ---
        broker.shutdown();
    }
}
