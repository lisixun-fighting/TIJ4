package com.zjuee.util;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size) {
        this.size = Math.max(size, 0);
    }
    public Integer get(int index) {
        return index;
    }
    public int size() {
        return this.size;
    }
    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
