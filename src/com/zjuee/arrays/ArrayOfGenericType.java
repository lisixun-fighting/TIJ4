package com.zjuee.arrays;

import java.lang.reflect.Array;

public class ArrayOfGenericType<T> {
    T[] array;
    Class<T> type;
    public ArrayOfGenericType(int sz, Class<T> type) {
        this.type = type;
        array = (T[]) Array.newInstance(type, sz);
    }
    public void add(T t, int i) {
        array[i] = t;
    }
}

class Test {
    public static void main(String[] args) {
        ArrayOfGenericType<BerylliumSphere> spheres = new ArrayOfGenericType<>(5, BerylliumSphere.class);
        spheres.add(new BerylliumSphere(), 1);

    }
}
