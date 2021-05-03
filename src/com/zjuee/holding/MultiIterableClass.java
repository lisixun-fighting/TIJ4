package com.zjuee.holding;

import java.util.*;

public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int cur = words.length-1;
                    @Override
                    public boolean hasNext() {
                        return cur >= 0;
                    }
                    @Override
                    public String next() {
                        return words[cur--];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> list = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(list);
                return list.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : mic.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : mic.randomized()) {
            System.out.print(s + " ");
        }
    }
}
