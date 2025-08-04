package org.example.lld.stackoverflow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question extends CreationInfo implements Votable, Commentable {
    private String questionId;
    private String title;
    private String content;
    private List<Answer> answers = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();
    private List<Tag> tags;

    public Question(String title, String content, List<Tag> tags, User author) {
        this.id = UUID.randomUUID().toString();
        this.questionId = "QUES_" + UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.createdBy = author;
        this.createdOn = LocalDateTime.now();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public String getQuestionId() {
        return this.questionId;
    }

    @Override
    public synchronized void addComment(Comment comment) {
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
        int point = VoteType.UPVOTE.equals(vote.getVoteType()) ? ReputationType.QUESTION_UPVOTE.getPoint() : ReputationType.QUESTION_DOWNVOTE.getPoint();
        author.updateReputation(point);
    }

    @Override
    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(vote -> vote.getVoteType().getValue())
                .sum();
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
