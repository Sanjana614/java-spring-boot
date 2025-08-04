package org.example.lld.stackoverflow;

public enum ReputationType {

    QUESTION_UPVOTE(5),
    QUESTION_DOWNVOTE(-2),
    ANSWER_UPVOTE(10),
    ANSWER_DOWNVOTE(-2),
    ANSWER_ACCEPTED(15);

    private final int point;

    ReputationType(int point) {
        this.point = point;
    }

    public int getPoint() {
        return this.point;
    }

}
