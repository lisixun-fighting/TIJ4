package com.zjuee.polymorphism.music;

import static net.mindview.util.Print.print;

class Stringed extends Instrument {
    public void play(Note n) {
        System.out.println("Stringed play() " + n);
    }

    @Override
    public String toString() {
        return "I am stringed.";
    }
}

class Brass extends Instrument {
    public void play(Note n) {
        System.out.println("Brass play() " + n);
    }

    @Override
    public String toString() {
        return "I am brass.";
    }
}

public class Music2 {

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }


    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[10];

        RandomGenerator gen = new RandomGenerator();

        for (int i = 0; i < instruments.length; i++)
            instruments[i] = gen.next();

        for (Instrument ins : instruments) {
            tune(ins);
            print(ins);
        }
    }
}
