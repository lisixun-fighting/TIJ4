package com.zjuee.practice.ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo03 {
    public static void main(String[] args) {
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String x = "Arline ate eight apples and one orange while Anita hadn't any";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(x);
        System.out.println(m.matches());
    }
}
