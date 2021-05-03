package com.zjuee.practice.ch17;

import com.zjuee.arrays.RandomGenerator;
import com.zjuee.util.Generator;
import java.util.*;

class A implements Comparable<A> {
    public String s1;
    public String s2;
    public int compareTo(A o) {
        return s1.compareTo(o.s1);
    }

    @Override
    public String toString() {
        return s1;
    }
}

public class Demo08 {

    static Generator<String> gen = new RandomGenerator.String();

    public static void main(String[] args) {
        List<A> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            A a = new A();
            a.s1 = gen.next();
            l.add(a);
        }
        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);
    }
}
