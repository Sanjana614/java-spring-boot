package org.example.lld.stackoverflow;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public final class StackOverflow {
    private static volatile StackOverflow instance;
    private Map<String, User> userMap;
    private Map<String, Question> questionMap;
    private Map<String, Answer> answerMap;
    private Map<String, Tag> tagMap;

    private StackOverflow() {
        this.userMap = new ConcurrentHashMap<>();
        this.questionMap = new ConcurrentHashMap<>();
        this.answerMap = new ConcurrentHashMap<>();
        this.tagMap = new ConcurrentHashMap<>();
    }

    public static StackOverflow getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (StackOverflow.class) {
                if (Objects.isNull(instance)) {
                    instance = new StackOverflow();
                }
            }
        }
        return instance;
    }

    public User addUser(String name, String email) {
        User user = new User(name, email);
        userMap.put(user.getUserId(), user);
        return user;
    }

    public Question postQuestion(String userId, String title, String content, List<String> questionTags) {
        User author = userMap.get(userId);
        if (Objects.isNull(author)) {
            System.out.println("User with userId: " + userId + " doesn't exists.");
            return null;
        }
        List<Tag> tags = new ArrayList<>();
        questionTags.forEach(questionTag -> {
            Tag tag = tagMap.getOrDefault(questionTag, new Tag(questionTag));
            tagMap.putIfAbsent(questionTag, tag);
            tags.add(tag);
        });
        Question question = new Question(title, content, tags, author);
        questionMap.put(question.getQuestionId(), question);
        return question;
    }

    public Answer postAnswer(String userId, String questionId, String content) {
        User author = userMap.get(userId);
        if (Objects.isNull(author)) {
            System.out.println("User with userId: " + userId + " doesn't exists.");
            return null;
        }
        if (!questionMap.containsKey(questionId)) {
            System.out.println("Question with questionId: " + questionId + " does not exists.");
            return null;
        }
        Question question = questionMap.get(questionId);
        Answer answer = new Answer(content, question, author);
        answerMap.put(answer.getAnswerId(), answer);
        question.addAnswer(answer);
        return answer;
    }

    public Comment addComment(String userId, Commentable commentable, String content) {
        User author = userMap.get(userId);
        if (Objects.isNull(author)) {
            System.out.println("User with userId: " + userId + " doesn't exists.");
            return null;
        }
        Comment comment = new Comment(author, content);
        commentable.addComment(comment);
        return comment;
    }

    public Vote vote(String userId, Votable votable, VoteType voteType) {
        User author = userMap.get(userId);
        if (Objects.isNull(author)) {
            System.out.println("User with userId: " + userId + " doesn't exists.");
            return null;
        }
        Vote vote = new Vote(author, voteType);
        votable.vote(vote);
        return vote;
    }

    public void acceptAnswer(String answerId) {
        Answer answer = answerMap.get(answerId);
        answer.markAsAccepted();
    }

    public List<Question> searchQuestions(String query) {
        return questionMap.values().stream()
                .filter(question ->
                        question.getTitle().toLowerCase().contains(query.toLowerCase())
                        || question.getContent().toLowerCase().contains(query.toLowerCase())
                        || question.getTags().stream().anyMatch(tag -> tag.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(String userId) {
        User user = userMap.get(userId);
        if (Objects.isNull(user)) {
            System.out.println("No user present with userId: " + userId);
            return Collections.emptyList();
        }
        return questionMap.values().stream()
                .filter(q -> user.equals(q.getAuthor()))
                .collect(Collectors.toList());
    }
}
