package com.zjuee.practice.ch21;

public class Demo01 {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++)
            new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread() + " Hello World. " + i);
                    Thread.yield();
                }
                System.out.println("See you tomorrow~~");
            }).start();
    }
}
