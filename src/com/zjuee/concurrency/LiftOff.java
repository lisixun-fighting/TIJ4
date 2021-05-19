package com.zjuee.concurrency;

public class LiftOff implements Runnable {
    protected int countDown = 1000000000;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") +"), ";
    }
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
        System.out.println("#" + id + " is over");
    }
}
