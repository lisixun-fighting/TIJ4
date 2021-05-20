package com.zjuee.practice.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Pool {
    private int value;
    public Pool(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public synchronized void change() {
        if (value == 0) return;
        value--;
        Thread.yield();
        value--;
    }
}

public class Demo04 implements Runnable {
    Pool pool;
    public Demo04(Pool pool) {
        this.pool = pool;
    }
    @Override
    public void run() {
        while (pool.getValue() > 0) {
            pool.change();
        }
        System.out.println(pool.getValue());
    }
    public static void main(String[] args) {
        Pool pool = new Pool(10000);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Demo04(pool));
        }
        exec.shutdown();
    }
}
