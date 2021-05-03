package com.zjuee.innerclass;

interface Selector {
    boolean end();
    Object current();
    void next();
}

class MyString<T> {
    T val;
    public MyString(T val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

public class Sequence<T> {
    private T[] items;
    private int next = 0;
    public Sequence(int size) { items = (T[])new Object[size]; }
    public void add(T x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }
        @Override
        public T current() {
            return items[i];
        }
        @Override
        public void next() {
            if(i < items.length) i++;
        }
    }
    private class ReverseSelector implements Selector {
        private int i = items.length-1;
        @Override
        public boolean end() {
            return i == -1;
        }
        @Override
        public T current() {
            return items[i];
        }
        @Override
        public void next() {
            if(i >= 0) i--;
        }
    }
    public SequenceSelector selector() {
        return new SequenceSelector();
    }
    public ReverseSelector reverser() { return new ReverseSelector(); }
    public static <T> void main(String[] args) {
        Sequence<MyString<String>> sequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new MyString<>("a"+i));
        }

        Sequence<MyString<String>>.SequenceSelector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();

        Sequence<MyString<String>>.ReverseSelector reverser = sequence.reverser();
        while(!reverser.end()) {
            System.out.print(reverser.current() + " ");
            reverser.next();
        }
    }
}
