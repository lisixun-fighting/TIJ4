package com.zjuee.holding;

import java.util.*;

import static net.mindview.util.Print.print;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        print("1: " + list);
        list.add(11);
        print("2: " + list);
        list.remove(4);
        print("3: " + list);
//        print("4: " + list.remove(12));
        List<Integer> sub = list.subList(1, 4);
        print("5: " + sub);
        print("6: " + list);
        print("7: " + list.containsAll(sub));
        Collections.sort(list);
        print("8: " + list);
        Collections.shuffle(list);
        print("9: " + list);
    }
}
