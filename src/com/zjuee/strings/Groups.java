package com.zjuee.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    static public final String POEM = "Technological progress is widely recognized as having considerable " +
            "impact on human societies, which have become more and more dependent on human-made tools that " +
            "entail intricate scientific processes, considered technology in the Related Works.\n" +
            " The adoption of such tools is borne out of the necessity of survival at first in the" +
            " Related Works, and subsequently as a means to improve access to food, shelter, and clothing;\n" +
            " arguably things that we cannot live without.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        System.out.println(m.groupCount());
        while(m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.print("[" + m.group(i) + "]");
            }
            System.out.println();
        }
        System.out.println();
        Matcher m2 = Pattern.compile("[a-z]\\w++(-\\w++)?").matcher(POEM);
        int count = 0;
        while (m2.find())
            count++;
        System.out.println(count);
    }
}
