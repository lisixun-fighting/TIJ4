package com.zjuee.util;

import java.util.Arrays;
import java.util.Random;

public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return CollectionData.list(gen, a.length).toArray(a);
    }
    // create a new Array
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[])java.lang.reflect.Array.newInstance(type, size);
        return array(a, gen);
    }

    public static void main(String[] args) {
        Integer[] array = array(Integer.class, new Generator<Integer>() {
            Random rand = new Random();
            public Integer next() {
                return rand.nextInt(5);
            }
        }, 5);
        System.out.println(Arrays.toString(array));
    }
}
