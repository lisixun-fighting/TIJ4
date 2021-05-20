package com.zjuee.concurrency;

import java.util.concurrent.TimeUnit;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        System.out.println(currentEvenValue);
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
