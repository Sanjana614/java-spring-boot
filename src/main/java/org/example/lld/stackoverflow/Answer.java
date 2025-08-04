package org.example.lld.stackoverflow;

import org.apache.commons.lang3.BooleanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer extends CreationInfo implements Votable, Commentable {

    private String answerId;
    private String content;
    private boolean accepted;
    private Question question;
    private List<Comment> comments = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public Answer(String content, Question question, User author) {
        this.id = UUID.randomUUID().toString();
        this.answerId = "ANS_" + UUID.randomUUID();
        this.question = question;
        this.content = content;
        this.createdBy = author;
        this.createdOn = LocalDateTime.now();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public synchronized void vote(Vote vote) {
        User voter = vote.getAuthor();
        boolean alreadyVotedByUser = votes.stream().anyMatch(v -> voter.equals(v.getAuthor()));
        if (alreadyVotedByUser) {
            throw new IllegalStateException("Already voted.");
        }
        votes.add(vote);
        User author = this.createdBy;
        int point = VoteType.UPVOTE.equals(vote.getVoteType()) ? ReputationType.ANSWER_UPVOTE.getPoint() : ReputationType.ANSWER_DOWNVOTE.getPoint();
        author.updateReputation(point);
    }

    @Override
    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(vote -> vote.getVoteType().getValue())
                .sum();
    }

    public String getAnswerId() {
        return this.answerId;
    }

    public synchronized void markAsAccepted() {
        if (BooleanUtils.isTrue(accepted)) {
            throw new IllegalStateException("This answer is already accepted.");
        }
        this.accepted = true;
        this.createdBy.updateReputation(ReputationType.ANSWER_ACCEPTED.getPoint());
    }

    public String getContent() {
        return content;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
