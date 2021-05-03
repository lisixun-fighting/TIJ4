package com.zjuee.arrays;

import com.zjuee.util.Generated;

import java.util.Arrays;

public class StringSorting {
    public static void main(String[] args) {
        String[] sa = Generated.array(String.class, new RandomGenerator.String(), 5);
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
    }
}
