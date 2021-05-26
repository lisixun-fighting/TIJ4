package com.zjuee.concurrency.juc;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;

class ExchangerProducer<T> implements Runnable {
    private final Supplier<T> generator;
    private final Exchanger<List<T>> exchanger;
    private List<T> holder;
    public ExchangerProducer(Supplier<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.get());
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException ignore) {
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private final Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x;
                    holder.remove(x);
                }
            }
        } catch (InterruptedException ignore) {
        }
        System.out.println("Final value: " + value);
    }
}

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(Fat::new, xc, producerList));
        exec.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
