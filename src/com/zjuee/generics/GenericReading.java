package com.zjuee.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());
    static void f() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f = readExact(apples);
    }
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }
    static void f2() {
        Reader<Fruit> fruitReader = new GenericReading.Reader<>();
        Fruit f = fruitReader.readExact(fruits);
    }
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }
    static void f3() {
        CovariantReader<Fruit> fruitReader = new GenericReading.CovariantReader<Fruit>();
        Fruit fruit = fruitReader.readCovariant(fruits);
        Fruit fruit1 = fruitReader.readCovariant(apples);
    }
    public static void main(String[] args) {
        f();
        f2();
        f3();
    }
}
