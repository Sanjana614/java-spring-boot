package org.example.multithreading.executors.threadpool;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ForkJoinPoolPOC {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            stringList.add(String.valueOf(i));
        }
        ForkJoinPool executor = new ForkJoinPool(4);
//        ExecutorService executor = Executors.newFixedThreadPool(8);
        LocalDateTime from = LocalDateTime.now();
        System.out.println("hhhhhijkl | " + Thread.currentThread().getName());
        executor.submit(() -> {
            stringList.parallelStream().forEach(
                    (str) -> {
                        System.out.println(str + " | Thread Name " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }).get();

        executor.shutdown();
        executor.awaitTermination(300, TimeUnit.SECONDS);
        System.out.println("hey");
        LocalDateTime to = LocalDateTime.now();
        System.out.println(ChronoUnit.SECONDS.between(from, to));
        System.out.println("Hi");
    }
}
