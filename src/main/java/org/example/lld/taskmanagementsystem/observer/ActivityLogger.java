package org.example.lld.taskmanagementsystem.observer;

import org.example.lld.taskmanagementsystem.model.Task;

public class ActivityLogger implements TaskObserver {

    @Override
    public void update(Task task, String changeType) {
        System.out.println("LOGGER: Task '" + task.getTitle() + "' was updated. Change: " + changeType);
    }
}
