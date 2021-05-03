package com.zjuee.enumerated.factory;

import java.util.function.Supplier;

import static com.zjuee.enumerated.factory.CarFactory.*;

public class App {
    public static void main(String[] args) {
        Supplier<Car> factory1 = FerrariFactory.getConstructor();
        Supplier<Car> factory2 = FordFactory.getConstructor();
        Car car1 = factory1.get();
        Car car2 = factory2.get();
        System.out.println(car1.description());
        System.out.println(car2.description());
    }
}
