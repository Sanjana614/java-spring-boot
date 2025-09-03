package org.example.lld.taskmanagementsystem.state;

import org.example.lld.taskmanagementsystem.enums.TaskStatus;
import org.example.lld.taskmanagementsystem.model.Task;

public interface TaskState {
    void markInProgress(Task task);
    void markDone(Task task);
    void reopen(Task task);
    TaskStatus getTaskStatus();
}
