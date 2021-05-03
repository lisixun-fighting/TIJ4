package com.zjuee.strings;

public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s);
        System.out.println(s.replaceFirst("f\\w+", "located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring", "located"));
        System.out.println(s.replaceAll("[aeiou]","_"));
    }
}
