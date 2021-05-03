package com.zjuee.practice.ch5;

import static net.mindview.util.Print.print;

class Cup {
    Cup(int marker) {
        print("Cup(" + marker + ")");
    }
    void f(int marker) {
        print("f(" + marker + ")");
    }
}

class Cups {
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    static Cup cup1;
    static Cup cup2;

    public Cups() {
        print("Cups()");
    }
}

public class Demo01 {
    public static void main(String[] args) {
        print("Inside main");
        Cups.cup1.f(99);
    }
    static Cups cups1 = new Cups();
}
