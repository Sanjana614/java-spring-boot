package org.example.lld.pubsubsystem.subscriber;

import org.example.lld.pubsubsystem.enitity.Message;

public class NewsSubscriber extends Subscriber {

    public NewsSubscriber(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.printf("[Subscriber %s] received message '%s'%n", id, message.getPayload());
    }
}
