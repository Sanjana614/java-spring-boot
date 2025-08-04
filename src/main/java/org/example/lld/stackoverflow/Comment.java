package org.example.lld.stackoverflow;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment extends CreationInfo {

    private final String commentId;
    private final String content;

    public Comment(User author, String content) {
        this.id = UUID.randomUUID().toString();
        this.commentId = "COM_" + UUID.randomUUID();
        this.content = content;
        this.createdBy = author;
        this.createdOn = LocalDateTime.now();
    }
}
