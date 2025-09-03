package org.example.lld.taskmanagementsystem;

import org.example.lld.taskmanagementsystem.enums.TaskPriority;
import org.example.lld.taskmanagementsystem.enums.TaskStatus;
import org.example.lld.taskmanagementsystem.model.Task;
import org.example.lld.taskmanagementsystem.model.TaskList;
import org.example.lld.taskmanagementsystem.model.User;
import org.example.lld.taskmanagementsystem.observer.ActivityLogger;
import org.example.lld.taskmanagementsystem.strategy.TaskSortingStrategy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskManagementSystem {

    private static TaskManagementSystem instance;
    private Map<String, User> userMap = new HashMap<>();
    private Map<String, TaskList> taskListMap = new HashMap<>();
    private Map<String, Task> taskMap = new HashMap<>();

    private TaskManagementSystem() {
    }

    public static TaskManagementSystem getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (TaskManagementSystem.class) {
                if (Objects.isNull(instance)) {
                    instance = new TaskManagementSystem();
                }
            }
        }
        return instance;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        userMap.put(user.getId(), user);
        return user;
    }

    public TaskList createTaskList(String name) {
        TaskList taskList = new TaskList(name);
        taskListMap.put(taskList.getId(), taskList);
        return taskList;
    }

    public Task createTask(String title, String content, LocalDate dueDate, TaskPriority priority, String createdByUserId) {
        User createdBy = userMap.get(createdByUserId);
        if (Objects.isNull(createdBy)) {
            System.out.println("Created By User does not exists.!!");
            return null;
        }
        if (dueDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid due date.");
            return null;
        }
        Task task = getTask(title, content, dueDate, priority, createdBy);
        taskMap.put(task.getId(), task);
        return task;
    }

    private static Task getTask(String title, String content, LocalDate dueDate, TaskPriority priority, User createdBy) {
        return Task.builder()
                .title(title)
                .content(content)
                .dueDate(dueDate)
                .priority(priority)
                .createdBy(createdBy)
                .addObserver(new ActivityLogger())
                .build();
    }

    public void deleteTask(String taskId) {
        taskMap.remove(taskId);
    }

    public List<Task> searchTasks(String keyword, TaskSortingStrategy sortingStrategy) {
        List<Task> tasks = taskMap.values().stream()
                .filter(task -> task.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || task.getContent().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        sortingStrategy.sort(tasks);
        return tasks;
    }

    public List<Task> listTasksByStatus(TaskStatus status) {
        return taskMap.values().stream()
                .filter(task -> task.getCurrentState().getTaskStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<Task> listTasksByUser(String userId) {
        return taskMap.values().stream()
                .filter(task -> Objects.nonNull(task.getAssignee()) && userId.equals(task.getAssignee().getId()))
                .collect(Collectors.toList());
    }
}
