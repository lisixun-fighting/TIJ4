package com.zjuee.practice.ch21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DemoSleeping implements Runnable {

    private static int count = 0;

    private int id = count++;

    Random rand = new Random();

    public void run() {
        try {
            int duration = rand.nextInt(10) + 1;
            long sleepTime = System.nanoTime();
            TimeUnit.SECONDS.sleep(duration);
            long wakeTime = System.nanoTime();
            System.out.println(id + " Sleeping time is " + (wakeTime - sleepTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++)
            executor.execute(new DemoSleeping());
        executor.shutdown();
    }
}
