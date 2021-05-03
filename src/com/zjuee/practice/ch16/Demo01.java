package com.zjuee.practice.ch16;

import java.util.Arrays;
import java.util.Random;

public class Demo01 {
    public static double[][] createArrays(int volume, double max, double min) {
        double[][] res = new double[volume][volume];
        Random rand = new Random(47);
        for (int i = 0; i < volume; i++) {
            for (int j = 0; j < volume; j++) {
                res[i][j] = rand.nextDouble() * (max-min) + min;
            }
        }
        return res;
    }

    public static void printArray(Object[] array) {
        System.out.println(Arrays.deepToString(array));
    }

    static Object[] a;

    public static void main(String[] args) {
        double[][] res1 = createArrays(3, 2, 1);
        printArray(res1);

        System.out.println(Arrays.deepToString(new int[2][]));

    }
}
