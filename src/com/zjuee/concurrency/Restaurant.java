package com.zjuee.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
    private final int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private final Restaurant restaurant;
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null || !restaurant.cleaned)
                        wait();
                }
                System.out.print("Waitperson got " + restaurant.meal + ", ");
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                synchronized (restaurant.busBoy) {
                    restaurant.cleaned = false;
                    restaurant.busBoy.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private final Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if (++count == 10) {
                    System.out.println("Out of food, Closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                System.out.print("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("chef interrupted");
        }
    }
}

class BusBoy implements Runnable {
    Restaurant restaurant;
    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.cleaned)
                        wait();
                }
                restaurant.cleaned = true;
                System.out.println("Clean the table ");
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    boolean cleaned = true;
    final Chef chef = new Chef(this);
    final WaitPerson waitPerson = new WaitPerson(this);
    final BusBoy busBoy = new BusBoy(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant() {
        exec.execute(chef);
        exec.execute(busBoy);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Restaurant();
    }
}
