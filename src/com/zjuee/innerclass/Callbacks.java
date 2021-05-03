package com.zjuee.innerclass;

import static net.mindview.util.Print.print;

interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable{
    private int i = 0;
    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {
    public void increment() {
        print("Other operation");
    }
    static void f(MyIncrement mi) {
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        print(i);
    }
    private class Closure implements Incrementable {
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbr) {
        callbackReference = cbr;
    }
    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Caller caller1 = new Caller(c1);
        caller1.go();
        print("--------");
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller2.go();
        caller2.go();
    }
}
