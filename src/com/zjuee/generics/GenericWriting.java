package com.zjuee.generics;

import java.util.*;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();
    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
    }
}