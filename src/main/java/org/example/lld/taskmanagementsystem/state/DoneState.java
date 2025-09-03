package org.example.lld.taskmanagementsystem.state;

import org.example.lld.taskmanagementsystem.enums.TaskStatus;
import org.example.lld.taskmanagementsystem.model.Task;

public class DoneState implements TaskState {

    @Override
    public void markInProgress(Task task) {
        System.out.println("Task already completed.");
    }

    @Override
    public void markDone(Task task) {
        task.setCurrentState(new DoneState());
    }

    @Override
    public void reopen(Task task) {
        task.setCurrentState(new TodoState());
    }

    @Override
    public TaskStatus getTaskStatus() {
        return TaskStatus.DONE;
    }
}
