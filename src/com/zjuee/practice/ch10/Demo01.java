package com.zjuee.practice.ch10;

class Outer {
    class Inner {
        public String toString() {
            return msg();
        }
    }
    public Inner to() {
        return new Inner();
    }
    private String msg() {
        return "private out";
    }
}

public class Demo01 {
    public static void main(String[] args) {
        Outer.Inner in = new Outer().to();
        System.out.println(in);
    }
}
