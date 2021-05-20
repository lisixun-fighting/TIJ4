package com.zjuee.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread() {
        super(Integer.toString(++threadCount));
        this.setDaemon(true);
        start();
    }
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }
    public void run() {
        while (true) {
            System.out.print(this);
            if(--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++)
            new SimpleThread();
        TimeUnit.SECONDS.sleep(1);
    }
}
