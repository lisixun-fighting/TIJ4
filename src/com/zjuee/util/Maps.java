package com.zjuee.util;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void printKeys(Map<Integer,String> map){
        System.out.println("Size = " + map.size() + ". ");
        System.out.print("Keys: ");
        System.out.println(map.keySet());

    }

    public static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKeys(map);
        System.out.print("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());

    }

    public static void main(String[] args) {
        test(new HashMap<Integer,String>());
    }
}
