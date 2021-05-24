package com.zjuee.practice.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task {
    void waiting() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

public class DemoInterrupt implements Runnable {
    Task t = new Task();
    public void run() {
        t.waiting();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new DemoInterrupt());
        TimeUnit.MILLISECONDS.sleep(200);
        exec.shutdownNow();
    }
}
