package com.zjuee.reusing;

class Engine {
    public void start() {}
    public void stop() {}
    public void service() {}
}

class Window {
    public void inflate(int psi) {}
}

class Door {
    public Window window = new Window();
    public void open() {}
    public void close() {}
}

public class Car {
    public Engine engine = new Engine();
    public Door
        left = new Door(),
        right = new Door();
    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.inflate(1);
        car.engine.service();
    }
}
