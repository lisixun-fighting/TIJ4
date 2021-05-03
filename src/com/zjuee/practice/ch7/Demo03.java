package com.zjuee.practice.ch7;

import static net.mindview.util.Print.print;

class Amphibian {
    void jump() {}
    void say() { print("I am Amphibian"); }
}

class Frog extends Amphibian {
    void eatInsect() {}

    @Override
    void say() { print("I am frog"); }
}

public class Demo03 {
    public static void main(String[] args) {
        Amphibian f = new Frog();
        f.jump();
        f.say();
        ((Frog) f).eatInsect();
    }
}
