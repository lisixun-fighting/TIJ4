package com.zjuee.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int n) {
        this.n = n;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }
            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer res : new IterableFibonacci(10)) {
            System.out.println(res);
        }
    }
}
