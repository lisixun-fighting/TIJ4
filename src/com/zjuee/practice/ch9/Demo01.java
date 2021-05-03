package com.zjuee.practice.ch9;

abstract class A {

    public A() {
        print();
    }

    abstract void print();

    static String name() {
        return "A";
    }
}

public class Demo01 extends A {

    int num = 1;

    @Override
    void print() {
        System.out.println(num + name());
    }

    public static void main(String[] args) {
        Demo01 d = new Demo01();
    }
}
