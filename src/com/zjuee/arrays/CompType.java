package com.zjuee.arrays;

import com.zjuee.util.Generator;
import com.zjuee.util.Generated;

import java.util.Arrays;
import java.util.Random;

public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if(count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }
    @Override
    public int compareTo(CompType o) {
        return Integer.compare(i, o.i);
    }
    private static final Random r = new Random(47);
    public static Generator<CompType> generator() {
        return () -> new CompType(r.nextInt(100), r.nextInt(100));
    }
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        System.out.println("before sorting: ");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sorting: ");
        System.out.println(Arrays.toString(a));
    }

}
