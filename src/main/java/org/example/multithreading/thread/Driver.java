package org.example.multithreading.thread;

import java.util.concurrent.Callable;

class Test1 extends Thread {
    @Override
    public void run() {
        System.out.println("code executed by thread : " + Thread.currentThread().getName());
    }
}

class Test2 implements Runnable {

    @Override
    public void run() {
        System.out.println("In class Test2 : " + Thread.currentThread().getName());
    }
}

class Test3 implements Runnable {

    @Override
    public void run() {
        System.out.println("In class Test3 : " + Thread.currentThread().getName());
    }
}

class Test4 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Test4";
    }
}

public class Driver {
    public static void main(String[] args) {
        System.out.println("Going inside Main method : " + Thread.currentThread().getName());
//        Test1 obj = new Test1();
//        obj.start();
        for (int i = 0; i < 10; i++) {
            Thread t2 = new Thread(new Test2());
            t2.start();
        }
        System.out.println("Finish main method : " + Thread.currentThread().getName());
    }
}
