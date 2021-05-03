package com.zjuee.practice.ch16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Demo04 {
    public static void main(String[] args) {
        Integer[] a = new Integer[20];
        Random rand = new Random(47);
        for (int i = 0; i < 20; i++) {
            a[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
    }
}
