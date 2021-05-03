package com.zjuee.innerclass;

public class TestBed {
    public void f() {
        System.out.println("f()");
    }
    public static class Tester {
        public static void main(String[] args) {
            TestBed bed = new TestBed();
            bed.f();
        }
    }
}
