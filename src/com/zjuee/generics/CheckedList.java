package com.zjuee.generics;

import com.zjuee.typeinfo.pets.*;

import java.util.*;

public class CheckedList {
    static void oldStyleMethod(List probableDogs) {
        probableDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
        oldStyleMethod(dogs1);

        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            System.err.println(e);
        }


    }
}
