package com.zjuee.practice.ch7;

/**
 * SingleTon design-pattern
 */
public class SingleTon {
    static class inner {
        static SingleTon instance = new SingleTon();
    }
    static SingleTon getInstance() {
        return inner.instance;
    }
}
