package com.zjuee.typeinfo;

import com.zjuee.typeinfo.factory.Factory;
import com.zjuee.util.TypeCounter;

import java.util.*;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).creat();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter creat() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter creat() {
            return new AirFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt creat() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt creat() {
            return new GeneratorBelt();
        }
    }
}

public class RegisteredFactory {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        for (int i = 0; i < 10; i++) {
            Part p = Part.createRandom();
            System.out.println(p + " ");
            counter.count(p);
        }
        System.out.println();
        System.out.println(counter);

    }
}
