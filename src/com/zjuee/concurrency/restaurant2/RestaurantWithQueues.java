package com.zjuee.concurrency.restaurant2;

import com.zjuee.enumerated.menu.*;
import java.util.*;
import java.util.concurrent.*;

class Order {
    private static int counter = 0;
    private final int id= counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final Food food;
    public Order(Customer customer, WaitPerson waitPerson, Food food) {
        this.customer = customer;
        this.waitPerson = waitPerson;
        this.food = food;
    }
    public Food item() {
        return food;
    }
    public Customer getCustomer() {
        return customer;
    }
    public WaitPerson getWaitPerson() {
        return waitPerson;
    }
    public String toString() {
        return String.format("Order: %d item: %s for: %s served by: %s",
                id, food, customer, waitPerson);
    }
}

class Plate {
    private final Order order;
    private final Food food;
    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }
    public Order getOrder() {
        return order;
    }
    public Food getFood() {
        return food;
    }
    public String toString() {
        return food.toString();
    }
}

class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();
    public Customer(WaitPerson waitPerson) {
        this.waitPerson = waitPerson;
    }
    public void deliver(Plate p) throws InterruptedException {
        // Only blocks if customer is still eating the previous course
        placeSetting.put(p);
    }
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.selectRandom();
            try {
                waitPerson.placeOrder(this, food);
                System.out.println(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + "waiting for " + course + " interrupted");
                break;
            }
        }
        System.out.println(this + " finished meal, leaving");
    }
    public String toString() {
        return "Customer " + id + " ";
    }
}

class WaitPerson implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> fillOrders = new LinkedBlockingDeque<>();
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void placeOrder(Customer cust, Food food) {
        // Shouldn't actually block because this is a LinkedBlockingQueue with no size limit
        try {
            restaurant.orders.put(new Order(cust, this, food));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until a course is ready
                Plate plate = fillOrders.take();
                System.out.println(this + "received " + plate + " delivering to " +
                        plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }
    public String toString() {
        return "WaitPerson " + id + " ";
    }
}

class Chef implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);
    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until an order appears
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().fillOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }
    public String toString() {
        return "Chef " + id + " ";
    }
}

class Restaurant implements Runnable {
    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingDeque<>();
    public Restaurant(ExecutorService exec, int nWaitPersons, int nChefs) {
        this.exec = exec;
        for (int i = 0; i < nWaitPersons; i++) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
                Customer c = new Customer(wp);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Restaurant interrupted");
        }
    }
}

public class RestaurantWithQueues {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Restaurant(exec, 5, 2));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
