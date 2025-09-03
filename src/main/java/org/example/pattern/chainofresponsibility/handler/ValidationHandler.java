package org.example.pattern.chainofresponsibility.handler;

import org.apache.commons.lang3.StringUtils;
import org.example.pattern.chainofresponsibility.model.RequestDto;

public class ValidationHandler extends BaseHandler<RequestDto> {

    @Override
    public void handle(RequestDto request) {
        if (StringUtils.isBlank(request.getPayload())) {
            System.out.println("Invalid payload!");
            return;
        }
        System.out.println("Valid payload!!");
        forward(request);
    }
}
