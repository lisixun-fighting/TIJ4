package com.zjuee.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class MyException2 extends Exception {
    private int x;
    private static Logger logger = Logger.getLogger("MyException2");
    public MyException2() {
    }
    public MyException2(String msg) {
        super(msg);
    }
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }
    public int val() {
        return x;
    }
    public String getMsg() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
    public static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
//        System.out.println(trace.toString());
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }
    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 e) {
            MyException2.logException(e);
            System.out.println("e.val() = " + e.val());
        }
    }
}
