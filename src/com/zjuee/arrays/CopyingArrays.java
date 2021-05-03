package com.zjuee.arrays;

import com.zjuee.util.Generated;

import java.util.Arrays;

public class CopyingArrays {
    public static void main(String[] args) {

        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);

        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));

        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));

        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        System.out.println("k= " + Arrays.toString(k));

        System.out.println("--------");
        BerylliumSphere[] src = Generated.array(BerylliumSphere.class, BerylliumSphere::new, 10);
        BerylliumSphere[] obj = Arrays.copyOf(src, 10);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(obj));
        src[1].setId(-1);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(obj));
    }
}
