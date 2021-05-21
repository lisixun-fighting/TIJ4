package com.zjuee.practice.ch21;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class DemoTimer {
    public void timed() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("One timer circle end..." + System.nanoTime());
                new DemoTimer().timed();
            }
        }, 1000);
    }

    public static void main(String[] args) {
        new DemoTimer().timed();
    }
}
