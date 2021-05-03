package com.zjuee.strings;

import java.util.Formatter;

public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %s\n", u);
        f.format("s: %c\n", u);
        f.format("s: %b\n", u); //true
        f.format("s: %h\n", u); // 61

        int v = 121;
        System.out.println("v = 121");
        f.format("d: %d\n", v);
        f.format("c: %c\n", v); // y
        f.format("b: %b\n", v); // true
        f.format("s: %s\n", v);
//        f.format("f: %f\n", v); // IllegalFormatConversionException
        f.format("x: %x\n", v);
        f.format("h: %h\n", v);

    }
}
