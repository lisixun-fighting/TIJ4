package com.zjuee.practice.ch15;

import java.util.*;

public class Demo05 {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
//        List<Number> list = new ArrayList<Integer>();  // Compiled error
        List<? extends Number> list = new ArrayList<Integer>();
    }
}
