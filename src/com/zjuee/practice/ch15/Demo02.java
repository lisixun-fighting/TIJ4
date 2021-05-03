package com.zjuee.practice.ch15;

import com.zjuee.generics.Fibonacci;

import java.util.Iterator;

class IterableFibonacci implements Iterable<Integer> {
    Fibonacci fib = new Fibonacci();
    int n;
    public IterableFibonacci(int count) {
        n = count;
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
                return fib.next();
            }
        };
    }
}

public class Demo02 {
    public static void main(String[] args) {
        for (Integer res : new IterableFibonacci(10)) {
            System.out.println(res);
        }
    }
}
