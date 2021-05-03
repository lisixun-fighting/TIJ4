package com.zjuee.strings;

public class Rudolph {
    public static void main(String[] args) {
        for (String regex : new String[] {
                "Rudolph", "[rRa]udolph", "[rR][aeiou][a-z]ol.*","^[rR][aeiou][a-z]ol.*$"
        }) {
            System.out.println("Rudolph".matches(regex));
        }
    }
}
