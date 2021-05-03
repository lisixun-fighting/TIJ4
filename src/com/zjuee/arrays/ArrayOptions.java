package com.zjuee.arrays;

import java.util.Arrays;

public class ArrayOptions {



    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        System.out.println("b: " + Arrays.toString(b));
        for (int i = 0; i < b.length; i++) {
            if(b[i] == null) {
                b[i] = new BerylliumSphere();
            }
        }
        System.out.println("b: " + Arrays.toString(b));

    }
}
