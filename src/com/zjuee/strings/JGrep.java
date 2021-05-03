package com.zjuee.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


// JGrep
public class JGrep {
    public static void main(String[] args) {
        Pattern p = Pattern.compile(".+");
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile("src/com/zjuee/strings/JGrep.java")) {
            m.reset(line);
            while(m.find()) {
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
            }
        }
    }
}
