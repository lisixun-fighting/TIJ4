package com.zjuee.holding;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            pq.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(pq);
        List<Integer> ints = Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,14,19,21,23,25);
        pq = new PriorityQueue<>(ints);
        QueueDemo.printQ(pq);
        pq = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        pq.addAll(ints);
        QueueDemo.printQ(pq);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> pqs = new PriorityQueue<>(strings);
        QueueDemo.printQ(pqs);

    }
}
