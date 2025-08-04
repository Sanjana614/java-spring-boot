package org.example.lld.stackoverflow;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String email;
    private int reputation;

    public User(String userName, String email) {
        this.userId = "USER_" + UUID.randomUUID();
        this.name = userName;
        this.email = email;
        this.reputation = 0;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return this.userId;
    }

    public long getReputation() {
        return this.reputation;
    }

    public synchronized void updateReputation(int point) {
        this.reputation += point;
        if (this.reputation < 0) {
            this.reputation = 0;
        }
    }
}
