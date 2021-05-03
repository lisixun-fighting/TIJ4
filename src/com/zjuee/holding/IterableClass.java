package com.zjuee.holding;

import java.util.Iterator;
import java.util.Map;

public class IterableClass implements Iterable<String> {
    protected String[] words = "And that is how we know the Earth to be banana-shaped.".split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }
            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        IterableClass strings = new IterableClass();
//        for (String s : strings) {
//            System.out.print(s + " ");
//        }
        for (Map.Entry<String, String> e : System.getenv().entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
}
