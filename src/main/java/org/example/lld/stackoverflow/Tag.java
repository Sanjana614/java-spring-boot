package org.example.lld.stackoverflow;

import java.util.UUID;

public class Tag {
    private String id;
    private String name;

    public Tag(String name) {
        this.id = "TAG_" + UUID.randomUUID();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
