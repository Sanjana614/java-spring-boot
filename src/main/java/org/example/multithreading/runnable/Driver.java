package org.example.multithreading.runnable;

class Test implements Runnable {
    @Override
    public void run() {
        System.out.println("code executed by thread : " + Thread.currentThread().getName());
    }
}

public class Driver {
    public static void main(String[] args) {
        System.out.println("Going inside Main method : " + Thread.currentThread().getName());
        Test obj = new Test();
        Thread t1 = new Thread(obj);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finish main method : " + Thread.currentThread().getName());
    }
}
