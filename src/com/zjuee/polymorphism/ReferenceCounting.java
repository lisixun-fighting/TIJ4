package com.zjuee.polymorphism;

import static net.mindview.util.Print.print;

class Shared {
    private static int count = 0;
    private final int id;
    private int refCount = 0;
    Shared() {
        print("Create Shared");
        id = ++count;
    }
    void addRef() {
        refCount++;
    }
    void dispose() {
        if(--refCount <= 0)
            print("Shared dispose()");
    }
}

class Composing {
    private Shared shared;
    private static int count = 0;
    private final int id;
    Composing(Shared shared) {
        print("Create Composing");
        id = count++;
        this.shared = shared;
        shared.addRef();
    }
    void dispose() {
        print("dispose Composing");
        shared.dispose();
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();
        Composing[] cs = new Composing[]{new Composing(s1), new Composing(s2), new Composing(s1),
        new Composing(s2), new Composing(s1), new Composing(s2)};
        for (Composing c : cs) {
            c.dispose();
        }
    }
}