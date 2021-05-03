package com.zjuee.polymorphism.music;

public class Wind extends Instrument{
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "I am a wind.";
    }
}
