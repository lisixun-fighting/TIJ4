package com.zjuee.enumerated.factory;

import java.lang.reflect.Constructor;
import java.util.function.Supplier;

public enum CarFactory {

    FerrariFactory(Ferrari::new),
    FordFactory(Ford::new);

    private Supplier<Car> constructor;

    CarFactory(Supplier<Car> supplier) {
        this.constructor = supplier;
    }

    Supplier<Car> getConstructor() {
        return constructor;
    }
}
