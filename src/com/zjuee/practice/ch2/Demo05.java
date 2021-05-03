package com.zjuee.practice.ch2;

import static net.mindview.util.Print.print;

public class Demo05 {

    public static void main(String[] args) {
        isEqual("abc", "abc");
        String s1 = "def";
        isEqual(s1, s1);
    }

    static void isEqual(String s1, String s2) {
        print("s1 == s2 : " + s1 == s2);
        print("s1.equals(s2) : " + s1.equals(s2));
    }
}
