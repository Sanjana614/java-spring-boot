package org.example.lld.pubsubsystem.subscriber;

import org.example.lld.pubsubsystem.enitity.Message;

public abstract class Subscriber {
    protected final String id;

    protected Subscriber(String id) {
        this.id = id;
    }

    public abstract String getId();
    public abstract void onMessage(Message message);
}
