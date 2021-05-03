package com.zjuee.typeinfo;

import java.util.*;

class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {
        this.type = type;
    }
    public List<T> create(int nElements) {
        List<T> res = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                res.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        List<CountedInteger> res = fl.create(10);
        System.out.println(res);
    }
}
