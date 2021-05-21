package com.zjuee.practice.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class A {
    private int value = 100;
    private final Object syncObject = new Object();
    public void f1() {
        while (value > 0)
            synchronized (syncObject) {
                if (value < 0) return;
                System.out.println("f1(): " + value--);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException ignore) {
                }
            }
    }
    public void f2() {
        while (value > 0)
            synchronized (syncObject) {
                if (value < 0) return;
                System.out.println("f2(): " + value--);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException ignore) {
                }
            }
    }
    public void f3() {
        while (value > 0)
            synchronized (syncObject) {
                if (value < 0) return;
                System.out.println("f3(): " + value--);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException ignore) {
                }
            }
    }
}

public class DemoSynch {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        A a = new A();
        exec.execute(new Thread(a::f1));
        exec.execute(new Thread(a::f2));
        exec.execute(new Thread(a::f3));
        exec.shutdown();
    }
}
