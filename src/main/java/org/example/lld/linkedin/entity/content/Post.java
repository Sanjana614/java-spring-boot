package org.example.lld.linkedin.entity.content;

import org.example.lld.linkedin.entity.Member;
import org.example.lld.linkedin.entity.Notification;
import org.example.lld.linkedin.enums.NotificationType;
import org.example.lld.linkedin.enums.ReactionType;
import org.example.lld.linkedin.observer.NotificationObserver;
import org.example.lld.linkedin.observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post extends AuditMetadata implements Subject {
    private final String id;
    private String title;
    private String content;
    private final List<Comment> comments;
    private final List<Reaction> reactions;
    private final List<NotificationObserver> observers;

    public Post(Member createdBy, String title, String content) {
        super(createdBy);
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
        this.reactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        observers.add(createdBy);
    }

    public void addReaction(Member member, ReactionType reactionType) {
        reactions.add(new Reaction(member, reactionType));
        notifyObservers(new Notification("Reaction added", "You got a " + reactionType, member.getId(), NotificationType.REACTION));
    }

    public void addComment(Member member, String content) {
        comments.add(new Comment(member, content));
        notifyObservers(new Notification("Comment added", "You got a comment", member.getId(), NotificationType.COMMENT));
    }

    @Override
    public void addObserver(NotificationObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(Notification notification) {
        this.observers.forEach(observer -> observer.update(notification));
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                ", reactions=" + reactions +
                '}';
    }
}
