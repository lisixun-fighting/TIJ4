package com.zjuee.generics;

public class Manipulation<T extends Hasf> {
    private T obj;
    public Manipulation(T x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }

    public static void main(String[] args) {
        Manipulation<Hasf> m = new Manipulation<>(new Hasf());
        m.manipulate();
    }
}
