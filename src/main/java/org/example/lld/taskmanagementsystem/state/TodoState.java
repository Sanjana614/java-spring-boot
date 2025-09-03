package org.example.lld.taskmanagementsystem.state;

import org.example.lld.taskmanagementsystem.enums.TaskStatus;
import org.example.lld.taskmanagementsystem.model.Task;

public class TodoState implements TaskState {

    @Override
    public void markInProgress(Task task) {
        task.setCurrentState(new InProgressState());
    }

    @Override
    public void markDone(Task task) {
        System.out.println("Not in progress.");
    }

    @Override
    public void reopen(Task task) {
        System.out.println("Already in todo state.");
    }

    @Override
    public TaskStatus getTaskStatus() {
        return TaskStatus.TODO;
    }
}
