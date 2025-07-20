package org.example.multithreading.monitorlock;

public class MonitorLockExample {
    public synchronized void method1() {
        System.out.println("inside method1 - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("finishing method1 - " + Thread.currentThread().getName());
    }

    public void method2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("inside method2 before synchronized block - " + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("inside method2 - " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void method3() {
        System.out.println("inside method3 - " + Thread.currentThread().getName());
    }
}
