package org.example.lld.linkedin.entity.profile;

import org.example.lld.linkedin.entity.Skill;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String heading;
    private String summary;
    private final List<Education> educations;
    private final List<Experience> experiences;
    private final List<Skill> skills;

    public Profile() {
        this.educations = new ArrayList<>();
        this.experiences = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addEduction(Education education) {
        this.educations.add(education);
    }

    public void addExperience(Experience experience) {
        this.experiences.add(experience);
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public String getHeading() {
        return heading;
    }

    public String getSummary() {
        return summary;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "heading='" + heading + '\'' +
                ", summary='" + summary + '\'' +
                ", educations=" + educations +
                ", experiences=" + experiences +
                ", skills=" + skills +
                '}';
    }
}
