package com.zjuee.practice.ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^[A-Z]\\w*.$");
        Matcher m = p.matcher("Oaaa.");
        System.out.println(m.matches());
    }
}
