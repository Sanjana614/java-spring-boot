package org.example.multithreading.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSortDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            li.add((int) (Math.random() * 100));
        }
//        ExecutorService executor = Executors.newWorkStealingPool(2);
        ForkJoinPool executor = new ForkJoinPool(2);
        mergeSort(li, 0, li.size()-1, executor);
        System.out.println(li);
        executor.shutdown();
    }

    private static void mergeSort(List<Integer> li, int start, int end, ExecutorService executor) throws ExecutionException, InterruptedException {
        System.out.println("start: " + start + " end: " + end + " Thread :: mergeSort(): " + Thread.currentThread().getName());
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;

        Future<?> leftFuture = executor.submit(() -> {
            try {
                mergeSort(li, start, mid, executor);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<?> rightFuture = executor.submit(() -> {
            try {
                mergeSort(li, mid + 1, end, executor);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        leftFuture.get();
        rightFuture.get();
        mergedSortedList(li, start, mid, end);
    }

    private static void mergedSortedList(List<Integer> li, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        List<Integer> merged = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (li.get(i) <= li.get(j)) {
                merged.add(li.get(i));
                i++;
            } else {
                merged.add(li.get(j));
                j++;
            }
        }
        while (i <= mid) {
            merged.add(li.get(i));
            i++;
        }
        while (j <= end) {
            merged.add(li.get(j));
            j++;
        }
        for (int k = 0; k <= merged.size()-1; k++) {
            li.set(start + k, merged.get(k));
        }
    }
}
