package org.example.multithreading.executors.threadpool;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorPOC {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        // schedule to execute once after 2 second.
        executor.schedule(() -> {
            System.out.println("Hello World1 " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

//        executor.shutdown();

//        executor.scheduleAtFixedRate(() -> {
//            System.out.println("Hello World2 " + Thread.currentThread().getName());
//        }, 2, 3, TimeUnit.SECONDS);

//        executor.scheduleWithFixedDelay(() -> {
//            System.out.println("Hello World3 " + Thread.currentThread().getName());
//        }, 2, 4, TimeUnit.SECONDS);
//
//        CountDownLatch lock = new CountDownLatch(3);
//
//        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(() -> {
//            System.out.println("Hello World2 " + Thread.currentThread().getName());
//            lock.countDown();
//        }, 2, 3, TimeUnit.SECONDS);
//
//        try {
//            lock.await(20, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        scheduledFuture.cancel(true);
    }
}
