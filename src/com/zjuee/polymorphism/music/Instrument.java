package com.zjuee.polymorphism.music;

public class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }

    @Override
    public String toString() {
        return "I am an instrument";
    }
}
