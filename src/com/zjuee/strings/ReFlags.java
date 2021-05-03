package com.zjuee.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expression\n" +
                        "Regular expressions are in Java\n");
        while(m.find()) {
            System.out.println(m.group());
        }
    }
}
