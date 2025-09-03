package org.example.lld.taskmanagementsystem.observer;

import org.example.lld.taskmanagementsystem.model.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}
