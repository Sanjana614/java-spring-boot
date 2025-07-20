package org.example.multithreading.executors.threadpool;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorPOC {
    public static void main(String[] args) {

        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);

        // schedule to execute once after 2 second.
        executor1.schedule(() -> {
            System.out.println("Hello World1 " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        executor1.schedule(() -> {
            System.out.println("Hello World2 " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        executor1.schedule(() -> {
            System.out.println("Hello World3 " + Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        executor1.schedule(() -> {
            System.out.println("Hello World4 " + Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        System.out.println("Hello World001 " + Thread.currentThread().getName());

        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);

        // schedule to execute once after 2 second.
        executor2.schedule(() -> {
            System.out.println("Hello World1 " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        executor2.schedule(() -> {
            System.out.println("Hello World2 " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        executor2.schedule(() -> {
            System.out.println("Hello World3 " + Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        executor2.schedule(() -> {
            System.out.println("Hello World4 " + Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        System.out.println("Hello World001 " + Thread.currentThread().getName());

//        executor1.shutdown();

//        executor1.scheduleAtFixedRate(() -> {
//            System.out.println("Hello World2 " + Thread.currentThread().getName());
//        }, 2, 3, TimeUnit.SECONDS);

//        executor1.scheduleWithFixedDelay(() -> {
//            System.out.println("Hello World3 " + Thread.currentThread().getName());
//        }, 2, 4, TimeUnit.SECONDS);
//
//        CountDownLatch lock = new CountDownLatch(3);
//
//        ScheduledFuture<?> scheduledFuture = executor1.scheduleAtFixedRate(() -> {
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
