package com.zjuee.concurrency.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();
    public DelayedTask(int delta) {
        this.delta = delta;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        sequence.add(this);
    }
    // Strategy method
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger-System.nanoTime(), TimeUnit.NANOSECONDS);
    }
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        return Long.compare(trigger, that.trigger);
    }
    public void run() {
        System.out.print(this + " ");
    }
    public String toString() {
        return String.format("[%1$d]Task[%2$d]", delta,id);
    }
    public String summary() {
        return String.format("(%d:%d) ", id,delta);
    }
    public static class EndSentinel extends DelayedTask {
        private final ExecutorService exec;
        public EndSentinel(int delta, ExecutorService exec) {
            super(delta);
            this.exec = exec;
        }
        public void run() {
            System.out.println();
            for (DelayedTask pt : sequence)
                System.out.print(pt.summary());
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run();
        } catch (InterruptedException ignore) {
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}

public class DelayQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        for (int i = 0; i < 20; i++)
            queue.add(new DelayedTask(rand.nextInt(5000)));
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
