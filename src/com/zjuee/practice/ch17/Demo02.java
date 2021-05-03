package com.zjuee.practice.ch17;

import com.zjuee.util.Countries;

import java.util.*;
import java.util.stream.Stream;

public class Demo02 {
    public static void main(String[] args) {
        Set<Map.Entry<String, String>> entries = Countries.capitals().entrySet();
        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, String> e : entries) {
            if(e.getKey().charAt(0) == 'C') {
                set.add(e.getKey());
                map.put(e.getKey(), e.getValue());
            }
        }
        System.out.println(set);
        System.out.println(map);

        set.addAll(Countries.names());
        set.addAll(Countries.names());
        System.out.println(set);
    }
}
