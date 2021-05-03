package com.zjuee.arrays;

import com.zjuee.util.Generated;
import com.zjuee.util.Generator;

import java.util.Arrays;

public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        Integer[] ia = Generated.array(Integer.class, gen, 10);
        System.out.println(Arrays.toString(ia));
//        Arrays.sort(ia);
//        System.out.println(Arrays.toString(ia));
        for (int i = 0; i < 20; i++) {
            while (true) {
                int r = gen.next();
                int location = Arrays.binarySearch(ia, r);
                if(location > 0) {
                    System.out.println("Location of " + r + " is " + location +
                            ", a[" + location + "] = " + ia[location]);
                    break;
                }
            }
        }
    }
}
