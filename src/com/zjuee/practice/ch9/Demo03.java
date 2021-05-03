package com.zjuee.practice.ch9;

import java.util.Random;

import static net.mindview.util.Print.print;

interface Gamble {
    int play();
}

class Coin implements Gamble {
    Random rand = new Random();
    public int play() {
        return rand.nextInt(2);
    }
}

class Dice implements Gamble {
    Random rand = new Random();
    public int play() {
        return rand.nextInt(6)+1;
    }
}

interface GamblingHouse {
    Gamble getGamble();
}

class CoinHouse implements GamblingHouse {
    public Gamble getGamble() { return new Coin(); }
}

class DiceHouse implements GamblingHouse {
    public Gamble getGamble() { return new Dice(); }
}

public class Demo03 {
    static Gamble start(GamblingHouse house) {
        return house.getGamble();
    }

    public static void main(String[] args) {
        Gamble start = start(new CoinHouse());
        int res = start.play();
        print(res);
    }
}
