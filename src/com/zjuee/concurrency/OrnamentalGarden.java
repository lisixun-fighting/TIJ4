package com.zjuee.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count {
    private int count = 0;
    private final Random rand = new Random(47);
    public synchronized int increment() {
        int tmp = count;
        if (rand.nextBoolean())
            Thread.yield();
        return (count = ++tmp);
    }
    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    private static final Count count = new Count();
    private static final List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    ++number;
                }
                System.out.println(this + " Total: " + count.increment());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("Stopping: " + this);
    }
    public synchronized int getValue() {
        return number;
    }
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated!");
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
        System.exit(0);
    }
}
