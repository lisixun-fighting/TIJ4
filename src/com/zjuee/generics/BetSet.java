package com.zjuee.generics;

import java.util.*;

public class BetSet {
    Byte[] possibles = { 1,2,3,4,5,6,7,8,9 };
    Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));

    List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
    List<Integer> list2 = List.of(1,2);

    public void f() {
        list.add(1);
//        list2.add(2); // UnsupportedOperationException
        Integer[] array = new Integer[2];
        array = list.toArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        new BetSet().f();
    }
}
