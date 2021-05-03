package com.zjuee.arrays;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    public static String[] flavorSet(int n) {
        if(n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] res = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            res[i] = FLAVORS[t];
            picked[t] = true;
        }
        return res;
    }

    public static BerylliumSphere[] spheresSet(int n) {
        BerylliumSphere[] spheres = new BerylliumSphere[n];
        for (int i = 0; i < n; i++) {
            spheres[i] = new BerylliumSphere();
        }
        return spheres;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
