package com.zjuee.practice.ch17;

import com.zjuee.util.Countries;

import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(Countries.names(5));
        List<String> l2 = new LinkedList<>(Countries.names(5));

        Iterator<String> it1 = l1.iterator();
        Iterator<String> it2 = l2.iterator();
        while (it1.hasNext())
            System.out.print(it1.next() + " ");

        System.out.println();

        int index = 0;
        while (it2.hasNext()) {
            l1.add(index, it2.next());
            index += 2;
        }
        System.out.println(l1);



    }
}
