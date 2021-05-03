package com.zjuee.practice.ch10.p2;

import com.zjuee.practice.ch10.p1.MyInterface;

public class Outer {
    protected class Inner implements MyInterface {
        @Override
        public void method() {
            System.out.println("Inner method()");
        }
    }
    public Inner getInner() {
        return new Inner();
    }
}
