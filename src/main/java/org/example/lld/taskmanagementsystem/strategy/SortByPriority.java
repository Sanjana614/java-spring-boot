package org.example.lld.taskmanagementsystem.strategy;

import org.example.lld.taskmanagementsystem.model.Task;

import java.util.Comparator;
import java.util.List;

public class SortByPriority implements TaskSortingStrategy {

    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.getPriority().getValue()));
    }
}
