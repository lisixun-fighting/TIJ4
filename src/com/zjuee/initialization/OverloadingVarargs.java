package com.zjuee.initialization;

import java.util.Arrays;

public class OverloadingVarargs {
    static void f(float i, Character...args) {
        System.out.println("first");
    }

    static void f(int i, Character...args) {
        System.out.println("second");
    }

    static void f(String...ss) {
        System.out.println(Arrays.toString(ss));
    }

    public static void main(String[] args) {
        f(1,'a','b');
        f("a","b","c");
    }
}
