package com.zjuee.reusing;

import static net.mindview.util.Print.print;

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized");
}

public class BeetleA extends Beetle {
    private int ka = printInit("BeetleA.k initialized");
    public BeetleA() {
        print("k = " + ka);
        print("j = " + j);
    }
    private static int x3 = printInit("static BeetleA.x3 initialized");

    public static void main(String[] args) {
        print("BeetleA constructor");
        BeetleA b = new BeetleA();
    }
}