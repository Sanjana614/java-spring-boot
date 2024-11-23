package org.example.multithreading.executors.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolPOC {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        Future<Object> future = executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());

    }
}
