package com.zjuee.practice.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo03 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread() + " Hello World. " + j);
                    Thread.yield();
                }
                System.out.println("See you tomorrow~~");
            });
        }
        executor.shutdown();
    }
}
