package com.zjuee.practice.ch17;

import com.zjuee.util.Countries;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        boolean b = l1.addAll(Countries.names());
        System.out.println(l1);
        Collections.shuffle(l1);
        System.out.println(l1);
        l1.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(l1);
    }
}
