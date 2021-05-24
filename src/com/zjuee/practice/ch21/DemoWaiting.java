package com.zjuee.practice.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1 implements Runnable {
    public void run() {
        try {
            System.out.println("Task1 starts waiting");
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Task1");
        }
        System.out.println("Task1 End");
    }
}

class Task2 implements Runnable {
    final Task1 task1;
    public Task2(Task1 task1) {
        this.task1 = task1;
    }
    public void run() {
        try {
            System.out.println("Task2 notifyAll()");
            TimeUnit.MILLISECONDS.sleep(500);
            synchronized (task1) {
                task1.notify();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Task2");
        }
    }
}

public class DemoWaiting {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Task1 task1 = new Task1();
        exec.execute(task1);
        exec.execute(new Task2(task1));
        exec.shutdown();
    }
}
