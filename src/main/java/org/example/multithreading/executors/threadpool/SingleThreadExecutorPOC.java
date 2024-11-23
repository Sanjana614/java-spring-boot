package org.example.multithreading.executors.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleThreadExecutorPOC {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        AtomicInteger counter = new AtomicInteger(0);
        executor.submit(() -> {
            counter.set(3);
        });
        executor.submit(() -> {
            counter.compareAndSet(3, 2);
        });
        System.out.println(counter);
    }
}
