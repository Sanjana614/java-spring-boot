package org.example.pattern.chainofresponsibility.handler;

import java.util.Objects;

public abstract class BaseHandler<T> implements RequestHandler<T> {
    protected RequestHandler<T> next;

    public abstract void handle(T request);

    @Override
    public void setNext(RequestHandler<T> next) {
        this.next = next;
    }

    public final void forward(T request) {
        if (Objects.isNull(next)) {
            return;
        }
        next.handle(request);
    }
}
