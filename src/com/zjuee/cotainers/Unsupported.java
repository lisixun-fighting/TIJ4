package com.zjuee.cotainers;

import com.zjuee.typeinfo.interfacea.A;

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> sublist = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(sublist);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("list.set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I G K L M N".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("Collections.unmodifiableList()", Collections.unmodifiableList(list));
    }
}
