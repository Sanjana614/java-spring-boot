package org.example.pattern.chainofresponsibility.handler;

import org.example.pattern.chainofresponsibility.model.RequestDto;

public class RateLimitHandler extends BaseHandler<RequestDto> {

    @Override
    public void handle(RequestDto request) {
        if (request.getRequestCount() > 10) {
            System.out.println("Too many requests!");
            return;
        }
        System.out.println("Passed rate limiter.");
        forward(request);
    }
}
