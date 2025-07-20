package org.example.multithreading.concurrency;

class CounterManager {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment() {
        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
    }
}

public class UpdateCounterDemo {
    public static void main(String[] args) {
        CounterManager counterManager = new CounterManager();
        Thread t1 = new Thread(counterManager::increment);
        Thread t2 = new Thread(counterManager::increment);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counterManager.getCount());
    }
}
