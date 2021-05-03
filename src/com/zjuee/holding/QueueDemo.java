package com.zjuee.holding;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static <T> void printQ(Queue<T> queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        printQ(queue);
    }
}
