package com.zjuee.practice.ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02 {

    public static String s = "Java now has regular expression";

    public static void main(String[] args) {
        for (String regex : new String[] {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s*", "s+", "s{4}", "s{0,3}"}) {
            System.out.println("Regular expression: \"" + regex + "\"");
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);
            while(m.find()) {
                System.out.println("Match \"" + m.group() + "\" as positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }

}
