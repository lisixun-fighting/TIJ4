package com.zjuee.practice.ch11;

import java.util.*;

class Gerbil {
    int gerbilNumber;
    static int counter = 0;
    private String name;
    public Gerbil(String name) {
        this.name = name;
        gerbilNumber = counter++;
    }
    public void hop() {
        System.out.println(name + " #" + gerbilNumber + " is hopping.");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        Map<String, Gerbil> m = new HashMap<>();
        m.put("Fuzzy", new Gerbil("Fuzzy"));
        m.put("Spot", new Gerbil("Spot"));
        m.put("Tommy", new Gerbil("Tommy"));
        Set<String> set = m.keySet();
        Iterator<String> it = set.iterator();
        List<Map.Entry<String,Gerbil>> list = new ArrayList<>();
        while(it.hasNext()) {
            String key = it.next();
            System.out.println(key + " = " + m.get(key));
            m.get(key).hop();
        }

        System.out.println("After sorted by keyValue");
        boolean flag = list.addAll(m.entrySet());
        list.sort((e1, e2) -> e1.getKey().compareToIgnoreCase(e2.getKey()));
        for (Map.Entry<String, Gerbil> e : list) {
            System.out.println(e);
        }
    }
}
