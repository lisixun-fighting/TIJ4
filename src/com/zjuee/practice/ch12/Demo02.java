package com.zjuee.practice.ch12;

public class Demo02 {
    static void g() throws MyException1 {
        throw new RuntimeException(new MyException1());
    }
    static void f() throws MyException2 {
        try {
            g();
        } catch (MyException1 e) {
//            e.printStackTrace();
            throw new MyException2();
        }
    }

    public static void main(String[] args) throws Exception {
        f();
    }
}
