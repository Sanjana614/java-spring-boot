package org.example.pattern.chainofresponsibility.model;

public class RequestDto {
    private final String user;
    private final String role;
    private final int requestCount;
    private final String payload;

    public RequestDto(String user, String role, int requestCount, String payload) {
        this.user = user;
        this.role = role;
        this.requestCount = requestCount;
        this.payload = payload;
    }

    public String getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public String getPayload() {
        return payload;
    }
}
