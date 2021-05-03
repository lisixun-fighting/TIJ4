package com.zjuee.strings;

import java.util.Arrays;

public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in " +
            "forest... with a herring!";
    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
        split("(the|you)\\W+");
        split("a|e|i|o|u");
        split("the|you");
    }

}
