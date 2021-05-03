package com.zjuee.generics;

import com.zjuee.arrays.RandomGenerator;
import com.zjuee.util.Generator;

import java.util.Arrays;

class FArray {
    public static <T> T[] fill(T[] a, Generator<? extends T> gen) {
        for (int i = 0; i < a.length; i++)
            a[i] = gen.next();
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
        System.out.println(Arrays.toString(strings));

    }
}
