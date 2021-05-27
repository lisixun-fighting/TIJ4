package com.zjuee.util;

import java.io.PrintStream;

public class Print {
    public Print() {
    }
    public static void print(Object obj) {
        System.out.println(obj);
    }
    public static void print() {
        System.out.println();
    }
    public static void printnb(Object obj) {
        System.out.print(obj);
    }
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
