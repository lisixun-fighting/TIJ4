package com.zjuee.concurrency.juc;

import java.util.*;
import java.util.concurrent.*;

/**
 * CyclicBarrier
 */
class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static final Random rand = new Random(47);
    private final CyclicBarrier barrier;
    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    public synchronized int getStrides() {
        return strides;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (BrokenBarrierException ignore) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return "Horse " + id + " ";
    }
    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++)
            s.append("*");
        s.append(id);
        return s.toString();
    }
}

public class HorseRace {
    static final int FINISH_LINE = 75;
    private final List<Horse> horses = new ArrayList<>();
    private final ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorses, int pause) {
        barrier = new CyclicBarrier(nHorses, () -> {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < FINISH_LINE; i++)
                s.append("=");
            System.out.println(s);
            for (Horse horse : horses)
                System.out.println(horse.tracks());
            for (Horse horse : horses)
                if (horse.getStrides() >= FINISH_LINE) {
                    System.out.println(horse + " won!");
                    exec.shutdownNow();
                    return;
                }
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("barrier-action sleep interrupted");
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;
        new HorseRace(nHorse, pause);
    }
}
