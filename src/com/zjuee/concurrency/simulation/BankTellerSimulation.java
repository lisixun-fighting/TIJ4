package com.zjuee.concurrency.simulation;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Customer {
    private final int serviceTime;
    public Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    public int getServiceTime() {
        return serviceTime;
    }
    public String toString() {
        return String.format("[%d]", serviceTime);
    }
}

class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }
    public String toString() {
        if (size() == 0)
            return "[Empty]";
        StringBuilder res = new StringBuilder();
        for (Customer customer : this)
            res.append(customer);
        return res.toString();
    }
}

class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private static Random rand = new Random(47);
    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(300);
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

class Teller implements Runnable, Comparable<Teller> {
    private static int counter;
    private final int id = counter++;
    // Customers served during this shift
    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    public Teller(CustomerLine customers) {
        this.customers = customers;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customerServed++;
                    while (!servingCustomerLine)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
    }
    public synchronized void doSomethingElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }
    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine:"already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }
    public String toString() {
        return "Teller " + id + " ";
    }
    public String shortString() {
        return "T" + id;
    }
    // Used by priority queue
    public synchronized int compareTo(Teller other) {
        return Integer.compare(customerServed, other.customerServed);
    }
}

class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellerDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);
    public TellerManager(ExecutorService exec, CustomerLine customers, int adjustmentPeriod) {
        this.exec = exec;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        // start with a single teller
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }
    /**
     * This is actually a control system. By adjusting the numbers,
     * you can reveal stability issues in control mechanism.
     */
    public void adjustTellerNumber() {
        // If line is too long, add another teller:
        if (customers.size() / workingTellers.size() > 2) {
            if (tellerDoingOtherThings.size() > 0) {
                Teller teller = tellerDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        // If line is short enough, remove a teller
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2)
            reassignOneTeller();
        if (customers.size() == 0)
            while (workingTellers.size() > 1)
                reassignOneTeller();
    }
    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        if (teller != null)
            teller.doSomethingElse();
        tellerDoingOtherThings.offer(teller);
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.print(customers + " { ");
                for (Teller teller : workingTellers)
                    System.out.print(teller.shortString() + " ");
                System.out.print("}  ");
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }
    public String toString() {
        return "TellerManager";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
        System.out.println("Press 'Enter' to quit");
        int read = System.in.read();
        exec.shutdownNow();
    }
}
