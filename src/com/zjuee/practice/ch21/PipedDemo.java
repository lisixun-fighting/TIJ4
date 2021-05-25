package com.zjuee.practice.ch21;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class CharacterBlockingQueue extends LinkedBlockingQueue<Character> { }

class Sender implements Runnable {
    private CharacterBlockingQueue queue;
    private Random rand = new Random(47);
    public Sender(CharacterBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char c = 'A'; c <= 'z'; c++) {
                    queue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender interrupted");
        }
    }
}

class Receiver implements Runnable {
    private CharacterBlockingQueue queue;
    public Receiver(CharacterBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.print("Read: " + queue.take() + ", ");
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Receiver interrupted");
        }
    }
}

public class PipedDemo {
    public static void main(String[] args) throws InterruptedException {
        CharacterBlockingQueue queue = new CharacterBlockingQueue();
        Sender sender = new Sender(queue);
        Receiver receiver = new Receiver(queue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
