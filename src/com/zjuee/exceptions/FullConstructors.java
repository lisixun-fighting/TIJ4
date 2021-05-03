package com.zjuee.exceptions;

class MyException extends Exception {
    private String msg;
    public MyException() {}
    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.getMsg());
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.getMsg());
        }
    }
}
