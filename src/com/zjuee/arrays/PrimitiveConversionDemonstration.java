package com.zjuee.arrays;

import com.zjuee.util.ConvertTo;
import com.zjuee.util.Generated;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        int[] a1 = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(a1));

        Integer[] b = Generated.array(Integer.class, new RandomGenerator.Integer(), 15);
        int[] b1 = ConvertTo.primitive(b);
        System.out.println(Arrays.toString(b1));

        Double[] c = new Double[10];
        Generated.array(c, new CountingGenerator.Double());
        double[] c1 = ConvertTo.primitive(c);
        System.out.println(Arrays.toString(c1));
    }
}
