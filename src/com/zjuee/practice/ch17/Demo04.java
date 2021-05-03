package com.zjuee.practice.ch17;

import com.zjuee.arrays.RandomGenerator;
import com.zjuee.util.Generated;
import com.zjuee.util.Generator;

import java.util.TreeSet;

public class Demo04 {
    public static void main(String[] args) {
        Generator<String> gen = new RandomGenerator.String();
        TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < 20; i++) {
            set.add(gen.next());
        }
        System.out.println(set);
    }
}
