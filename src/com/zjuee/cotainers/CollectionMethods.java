package com.zjuee.cotainers;

import com.zjuee.util.Countries;

import java.util.*;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);
        // Make an array from the List;
        String[] str = c.toArray(new String[0]);
        // Find max and min elements
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));
        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);
        c.removeAll(c2);
        System.out.println(c);
        c.addAll(c2);
        System.out.println(c);

        String val = Countries.DATA[3][0];
        System.out.println("c.contains(val) " + val + " = " + c.contains(val));
        System.out.println("c.containsAll(c2) " + c2 + " = " + c.contains(c2));
        Collection<String> c3 = ((List<String>)c).subList(3,5);
        System.out.println(c3);
        c2.retainAll(c3);
        System.out.println(c2);
        c2.removeAll(c3);
        System.out.println("after c2.removeAll(c3)");
        System.out.println(c2);
        System.out.println(c3);

    }
}
