package com.zjuee.cotainers;

import com.zjuee.util.Countries;

import java.util.*;

public class Enumeration {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Countries.names());
        java.util.Enumeration<String> e = Collections.enumeration(list);
        while (e.hasMoreElements())
            System.out.println(e.nextElement());
    }
}
