package com.zjuee.arrays;

import com.zjuee.util.Generated;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        System.out.println("before sorting: ");
        System.out.println(Arrays.toString(a));
        System.out.println("after sorting: ");
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
    }
}
