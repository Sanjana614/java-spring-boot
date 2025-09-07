package org.example.lld.pubsubsystem.subscriber;

import org.example.lld.pubsubsystem.enitity.Message;

public class AlertSubscriber extends Subscriber {

    public AlertSubscriber(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.printf("!!! [ALERT - %s] : '%s' !!!%n", id, message.getPayload());
    }
}
