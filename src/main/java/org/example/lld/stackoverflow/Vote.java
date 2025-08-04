package org.example.lld.stackoverflow;

import java.time.LocalDateTime;
import java.util.UUID;

public class Vote extends CreationInfo {

    private final VoteType voteType;

    public Vote(User voter, VoteType voteType) {
        this.id = UUID.randomUUID().toString();
        this.createdBy = voter;
        this.createdOn = LocalDateTime.now();
        this.voteType = voteType;
    }

    public VoteType getVoteType() {
        return this.voteType;
    }
}
