package org.example.lld.linkedin.entity;

import org.example.lld.linkedin.entity.profile.Education;
import org.example.lld.linkedin.entity.profile.Experience;
import org.example.lld.linkedin.entity.profile.Profile;
import org.example.lld.linkedin.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member implements NotificationObserver {
    private final String id;
    private final String name;
    private final String email;
    private final Profile profile;
    private final List<Member> connections;
    private final List<Notification> notifications;

    public Member(MemberBuilder builder) {
        this.id = UUID.randomUUID().toString();
        this.name = builder.name;
        this.email = builder.email;
        this.profile = builder.profile;
        this.connections = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void addConnection(Member member) {
        this.connections.add(member);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void viewNotifications() {
        this.notifications.forEach(System.out::println);
    }

    public static MemberBuilder builder(String name, String email) {
        return new MemberBuilder(name, email);
    }

    @Override
    public void update(Notification notification) {
        notifications.add(notification);
    }

    public static class MemberBuilder {
        public String name;
        public String email;
        private Profile profile = new Profile();

        public MemberBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public MemberBuilder withSummary(String summary) {
            this.profile.setSummary(summary);
            return this;
        }

        public MemberBuilder addEducation(Education education) {
            this.profile.addEduction(education);
            return this;
        }

        public MemberBuilder addExperience(Experience experience) {
            this.profile.addExperience(experience);
            return this;
        }

        public MemberBuilder addSkill(Skill skill) {
            this.profile.addSkill(skill);
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    public void displayProfile() {
        System.out.println(profile);
    }
}
