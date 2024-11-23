package org.example.multithreading.executors.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolPOC {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        System.out.println(executor.getPoolSize()); // 2
        System.out.println(executor.getQueue().size()); // 1
        executor.shutdown();
    }
}
