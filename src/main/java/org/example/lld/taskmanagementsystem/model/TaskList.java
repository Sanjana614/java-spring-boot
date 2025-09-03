package org.example.lld.taskmanagementsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskList {
    private String id;
    private String name;
    private final List<Task> tasks = new ArrayList<>();

    public TaskList(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
