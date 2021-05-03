package com.zjuee.cotainers;

import com.zjuee.util.Countries;

import java.util.*;

public class ReadOnly {
    static Collection<String> data = new ArrayList<String>(Countries.names(6));
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(data);
        Collection<String> c = Collections.unmodifiableCollection(strings);
        System.out.println(c);
        try {
            c.add("one"); // UnsupportedOperationException
        }catch (UnsupportedOperationException e) {
            System.out.println(e);
        }
        strings.add("aaa");
        System.out.println(c);
//        Map<String, String> map = Collections.unmodifiableMap(new HashMap<String, String>(Countries.capitals(6)));
//        System.out.println(map);
    }
}
