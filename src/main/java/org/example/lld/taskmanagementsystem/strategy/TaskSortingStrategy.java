package org.example.lld.taskmanagementsystem.strategy;

import org.example.lld.taskmanagementsystem.model.Task;

import java.util.List;

public interface TaskSortingStrategy {
    void sort(List<Task> tasks);
}
