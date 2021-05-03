package com.zjuee.holding;

import java.util.*;

interface Selector {
    boolean end();
    Object current();
    void next();
}

class MyString {
    String val;
    public MyString(String val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return val;
    }
}

public class Sequence<T> {
    private List<T> items;
    private int next = 0;
    public Sequence() { items = new LinkedList<>(); }
    public void add(T x) {
        items.add(x);
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.size();
        }
        @Override
        public T current() {
            return items.get(i);
        }
        @Override
        public void next() {
            if(i < items.size()) i++;
        }
        public Sequence<T> getSeq() {
            return Sequence.this;
        }
    }
    public SequenceSelector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence<MyString> sequence = new Sequence<MyString>();
        for (int i = 0; i < 10; i++) {
            sequence.add(new MyString("a"+i));
        }
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();

    }
}

