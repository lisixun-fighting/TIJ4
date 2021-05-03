package com.zjuee.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice10 {
    public static void main(String[] args) {
        String s = "Java now has regular expressions";
        for (String arg : args) {
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(s);
            System.out.println(arg + " " + m.find());
        }
    }
}
