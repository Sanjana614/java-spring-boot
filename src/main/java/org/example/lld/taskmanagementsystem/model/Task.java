package org.example.lld.taskmanagementsystem.model;

import org.example.lld.taskmanagementsystem.enums.TaskPriority;
import org.example.lld.taskmanagementsystem.observer.TaskObserver;
import org.example.lld.taskmanagementsystem.state.TaskState;
import org.example.lld.taskmanagementsystem.state.TodoState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    private String id;
    private String title;
    private String content;
    private LocalDate dueDate;
    private User assignee;
    private User createdBy;
    private TaskPriority priority;
    private List<Task> subtasks;
    private List<Tag> tags;
    private List<Comment> comments;
    private List<ActivityLog> activityLogs = new ArrayList<>();
    private List<TaskObserver> observers;
    private TaskState currentState;

    public Task(TaskBuilder builder) {
        this.id = UUID.randomUUID().toString();
        this.title = builder.title;
        this.content = builder.content;
        this.dueDate = builder.dueDate;
        this.assignee = builder.assignee;
        this.createdBy = builder.createdBy;
        this.priority = builder.priority;
        this.subtasks = builder.subtasks;
        this.tags = builder.tags;
        this.comments = builder.comments;
        this.currentState = new TodoState();
        this.observers = builder.observers;
    }

    public void addSubtask(Task subTask) {
        this.subtasks.add(subTask);
        addLog("Subtask added.");
    }

    public void setAssignee(User user) {
        this.assignee = user;
        addLog("Task has been assigned.");
        notifyObserver("Assigned");
    }

    public void startProgress() {
        this.currentState.markInProgress(this);
        addLog("Stated in Progress.");
        notifyObserver("In Progress");
    }

    public void completeTask() {
        this.currentState.markDone(this);
        addLog("Task completed.");
        notifyObserver("Completed");
    }

    private void addLog(String description) {
        activityLogs.add(new ActivityLog(description));
    }

    private void notifyObserver(String changeType) {
        observers.forEach(observer -> observer.update(this, changeType));
    }

    public static TaskBuilder builder() {
        return new TaskBuilder();
    }

    public static class TaskBuilder {
        public TaskPriority priority;
        private String title;
        private String content;
        private LocalDate dueDate;
        private User assignee;
        public User createdBy;
        private List<Task> subtasks = new ArrayList<>();
        private List<Tag> tags = new ArrayList<>();
        private List<Comment> comments = new ArrayList<>();
        private List<TaskObserver> observers = new ArrayList<>();

        public TaskBuilder priority(TaskPriority priority) {
            this.priority = priority;
            return this;
        }

        public TaskBuilder title(String title) {
            this.title = title;
            return this;
        }

        public TaskBuilder content(String content) {
            this.content = content;
            return this;
        }

        public TaskBuilder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public TaskBuilder assignedBy(User assignedBy) {
            this.assignee = assignedBy;
            return this;
        }

        public TaskBuilder createdBy(User createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TaskBuilder subtasks(List<Task> subtasks) {
            this.subtasks = subtasks;
            return this;
        }

        public TaskBuilder tags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public TaskBuilder comments(List<Comment> comments) {
            this.comments = comments;
            return this;
        }

        public TaskBuilder addObserver(TaskObserver observer) {
            observers.add(observer);
            return this;
        }

        public Task build() {
            return new Task(this);
        }
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setCurrentState(TaskState taskState) {
        this.currentState = taskState;
    }

    public TaskState getCurrentState() {
        return this.currentState;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
