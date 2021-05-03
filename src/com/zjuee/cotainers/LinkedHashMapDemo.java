package com.zjuee.cotainers;

import com.zjuee.util.CountingMapData;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedMap);
        // LRU 算法
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        System.out.println(linkedMap);
        for (int i = 0; i < 6; i++)
            linkedMap.get(i);

        System.out.println(linkedMap);
        linkedMap.get(6);
        System.out.println(linkedMap);
    }
}
