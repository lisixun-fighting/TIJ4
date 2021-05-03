package com.zjuee.practice.ch16;

import com.zjuee.util.Generated;

import java.util.Arrays;
import java.util.Random;

public class Demo03 {

    static Random rand = new Random(47);

    public static void main(String[] args) {
        A[] a = Generated.array(A.class, () -> new A(rand.nextInt(20)), 20);
        System.out.println(Arrays.toString(a));
        System.out.println("After sort");
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
