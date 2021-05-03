package com.zjuee.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*!  Here is a block of text to use as input to the regular expression matcher. Note that we'll
     first extract the block of text by looking for the special delimiters, then process the
     extracted block. !*/
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("src/com/zjuee/strings/TheReplacements.java");
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if(mInput.find()) {
            s = mInput.group(1);
        }
        System.out.println(s);
        s = s.replaceAll("(?m)^\\s+", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        System.out.println(s);
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while(m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
            System.out.println(sb);
        }
    }
}
