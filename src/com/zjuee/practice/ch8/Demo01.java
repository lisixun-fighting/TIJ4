package com.zjuee.practice.ch8;

import static net.mindview.util.Print.print;

class A {
    public void say() {
        print("Hello " + name());
    }
    protected String name() {
        return "A";
    }
}

class B extends A {
    @Override
    protected String name() {
        return "B";
    }
}

public class Demo01 {
    public static void main(String[] args) {
        A b = new B();
        b.say();
    }
}
