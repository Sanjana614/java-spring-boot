package org.example.pattern.chainofresponsibility.handler;

import org.example.pattern.chainofresponsibility.model.RequestDto;

import java.util.Objects;

public class AuthHandler extends BaseHandler<RequestDto> {

    @Override
    public void handle(RequestDto requestDto) {
        if (Objects.isNull(requestDto.getUser())) {
            System.out.println("User not present.");
            return;
        }
        System.out.println("User Authentication successful.");
        forward(requestDto);
    }
}
