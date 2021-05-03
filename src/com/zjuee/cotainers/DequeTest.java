package com.zjuee.cotainers;

import com.zjuee.util.Deque;

public class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        System.out.println(di);
    }
}
