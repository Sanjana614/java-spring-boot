package org.example.pattern.chainofresponsibility;

import org.example.pattern.chainofresponsibility.handler.*;
import org.example.pattern.chainofresponsibility.model.RequestDto;

public class Main {
    public static void main(String[] args) {
        RequestHandler<RequestDto> auth = new AuthHandler();
        RequestHandler<RequestDto> authorize = new AuthorizationHandler();
        RequestHandler<RequestDto> rateLimit = new RateLimitHandler();
        RequestHandler<RequestDto> validation = new ValidationHandler();

        auth.setNext(authorize);
        authorize.setNext(rateLimit);
        rateLimit.setNext(validation);

        RequestDto requestDto1 = new RequestDto("VIKASH", "ADMIN", 5, "Valid Payload");
        auth.handle(requestDto1);

        System.out.println("==============================");
        RequestDto requestDto2 = new RequestDto("VIKASH", "USER", 5, "Valid payload");
        auth.handle(requestDto2);
    }
}
