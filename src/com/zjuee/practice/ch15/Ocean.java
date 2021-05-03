package com.zjuee.practice.ch15;

import com.zjuee.generics.Generators;
import com.zjuee.util.Generator;

import java.util.*;

class SmallFish {
    private static long counter = 1;
    private final long id = counter ++;
    private SmallFish() {}
    public String toString() { return "SmallFish-" + id; }
    public static Generator<SmallFish> generator() {
        return SmallFish::new;
    }
}

class BigFish {
    private static long counter = 1;
    private final long id = counter ++;
    private BigFish() {}
    public String toString() { return "BigFish-" + id; }
    public static Generator<BigFish> generator = BigFish::new;
}

public class Ocean {
    private static void serve(BigFish big, SmallFish small) {
        System.out.println(big + " eat " + small);
    }
    public static void main(String[] args) {
        Queue<BigFish> line = new LinkedList<>();
        Generators.fill(line, BigFish.generator, 4);
        List<SmallFish> lunch = new LinkedList<>();
        Generators.fill(lunch, SmallFish.generator(), 15);
        Random rand = new Random(47);
        for (BigFish bigFish : line) {
            serve(bigFish, lunch.get(rand.nextInt(lunch.size())));
        }
    }
}
