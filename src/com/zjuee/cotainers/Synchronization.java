package com.zjuee.cotainers;

import java.util.*;

public class Synchronization {
    public static void main(String[] args) {
        Collection<Object> c = Collections.synchronizedCollection(new ArrayList<>());
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        TreeMap<Object, Object> map1 = new TreeMap<>();
        SortedMap<Object, Object> sm = Collections.synchronizedSortedMap(map1);

    }
}
