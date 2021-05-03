package com.zjuee.interfaces;

import com.zjuee.polymorphism.music.Note;

import static net.mindview.util.Print.print;

interface Playable {
    public void play(Note n);
}

abstract class Instruments {
    void adjust() {
        print(this + ".adjust()");
    }
    public abstract String toString();
}

class Wind extends Instruments implements Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() {
        return "Wind";
    }
}

class Stringed extends Instruments implements Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Stringed {
    public String toString() {
        return "Brass";
    }
}

public class Music5 {
    static void tune(Playable e) {
        e.play(Note.C_SHARP);
    }
    static void tuneAll(Playable[] e) {
        for (Playable i : e) {
            i.play(Note.C_SHARP);
        }
    }

    public static void main(String[] args) {
        Playable[] e = {new Brass(), new Stringed(), new Wind()};
        tuneAll(e);
    }
}
