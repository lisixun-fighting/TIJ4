package com.zjuee.polymorphism.music;

import java.util.Random;

import static net.mindview.util.Print.print;

public class RandomGenerator {
    private static Random rand = new Random();
    public Instrument next() {
        switch (rand.nextInt(3)) {
            case 0:
                return new Brass();
            case 1:
                return new Wind();
            case 2:
                return new Stringed();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            print(rand.nextInt(3));
        }
    }
}
