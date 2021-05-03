package com.zjuee.practice.ch2;

import static net.mindview.util.Print.print;

class Dog {
    String name;
    String words;

    public Dog(String name, String words) {
        this.name = name;
        this.words = words;
    }

    void says() {
        print ("Dog " + name + " says " + words);
    }
}

public class Demo02 {
    public static void main(String[] args) {
        Dog spot = new Dog("spot","Ruff!");
        Dog scruffy = new Dog("scruffy","Wurf!");
        spot.says();
        scruffy.says();
        Dog fScruffy = scruffy;
        print(scruffy.equals(fScruffy));
    }
}
