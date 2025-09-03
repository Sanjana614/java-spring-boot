package org.example.pattern.chainofresponsibility.handler;

public interface RequestHandler<T> {
    void handle(T request);
    void setNext(RequestHandler<T> next);
}
