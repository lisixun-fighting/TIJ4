package com.zjuee.practice.ch14;

import com.zjuee.typeinfo.factory.Factory;
import com.zjuee.util.TypeCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(GeneratorBelt.class);
    }
    private static Random rand = new Random(47);
    public static Part createRandom() throws IllegalAccessException, InstantiationException {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).newInstance();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {

}

class AirFilter extends Filter {
}

class Belt extends Part {}

class FanBelt extends Belt {

}

class GeneratorBelt extends Belt {

}

public class Demo01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        TypeCounter counter = new TypeCounter(Part.class);
        for (int i = 0; i < 10; i++) {
            Part p = Part.createRandom();
            System.out.println(p);
            counter.count(p);
        }
        System.out.println(counter);
    }
}
