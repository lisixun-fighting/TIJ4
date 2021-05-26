package com.zjuee.concurrency.simulation;

import java.util.*;
import java.util.concurrent.*;

class Car {
    private final int id;
    private boolean engine = false, driveTrain = false, wheels = false;
    public Car(int idn) {
        id = idn;
    }
    public synchronized int getId() {
        return id;
    }
    public synchronized void addEngine() {
        engine = true;
    }
    public synchronized void addDriveTrain() {
        driveTrain = true;
    }
    public synchronized void addWheels() {
        wheels = true;
    }
    public synchronized String toString() {
        return String.format("Car %d [ engine: %b driveTrain: %b wheels: %b ]", id, engine, driveTrain, wheels);
    }
}

class CarQueue extends LinkedBlockingQueue<Car> {}

class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;
    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created " + c);
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}

class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;
    public Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }
    public Car car() {
        return car;
    }
    public CyclicBarrier barrier() {
        return barrier;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until chassis is available:
                car = chassisQueue.take();
                // Hire robot to perform work
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await();
                // Put car into finishingQueue for further work
                finishingQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

class Reporter implements Runnable {
    private CarQueue carQueue;
    public Reporter(CarQueue carQueue) {
        this.carQueue = carQueue;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(carQueue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}

abstract class Robot implements Runnable {
    private RobotPool pool;
    public Robot(RobotPool pool) {
        this.pool = pool;
    }
    protected Assembler assembler;
    public void assignAssembler(Assembler assembler) {
        this.assembler = assembler;
    }
    private boolean engage = false;
    public synchronized void engage() {
        engage = true;
        notifyAll();
    }
    // The part of run() that's different for each robot:
    abstract protected void performService();
    public void run() {
        try {
            while (!Thread.interrupted()) {
                powerDown(); // Wait until needed
                performService();
                assembler.barrier().await();
            }
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        }
    }
    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null;
        // Put ourselves back in the available pool:
        pool.release(this);
        while (!engage)
            wait();
    }
    public String toString() {
        return getClass().getSimpleName();
    }
}

class EngineRobot extends Robot {
    public EngineRobot(RobotPool pool) {
        super(pool);
    }
    protected void performService() {
        System.out.println(this + " installing Engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }
    protected void performService() {
        System.out.println(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool) {
        super(pool);
    }
    protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}

class RobotPool {
    private Set<Robot> pool = new HashSet<>();
    public synchronized void add(Robot r) {
        pool.add(r);
        notifyAll();
    }
    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
        for (Robot r : pool) {
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage(); // Power it up to do the task
                return;
            }
        }
        wait();
        hire(robotType, d);
    }
    public void release(Robot robot) {
        add(robot);
    }
}

public class CarBuilder {
    public static void main(String[] args) throws InterruptedException {
        CarQueue chassisQueue = new CarQueue(),
                finishedQueue = new CarQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new Assembler(chassisQueue, finishedQueue, robotPool));
        exec.execute(new Reporter(finishedQueue));
        exec.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
