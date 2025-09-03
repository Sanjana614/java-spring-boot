package org.example.pattern.chainofresponsibility.handler;

import org.example.pattern.chainofresponsibility.model.RequestDto;

public class AuthorizationHandler extends BaseHandler<RequestDto> {

    @Override
    public void handle(RequestDto request) {
        if (!"ADMIN".equalsIgnoreCase(request.getRole())) {
            System.out.println("User not authorized!");
            return;
        }
        System.out.println("User Authorized!");
        forward(request);
    }
}
