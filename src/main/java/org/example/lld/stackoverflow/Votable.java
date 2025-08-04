package org.example.lld.stackoverflow;

import java.util.List;

public interface Votable {
    void vote(Vote vote);
    List<Vote> getVotes();
    int getVoteCount();
}
