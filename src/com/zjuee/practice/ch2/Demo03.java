package com.zjuee.practice.ch2;

import static net.mindview.util.Print.print;

public class Demo03 {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 1;
        for (int i = 0; i < 16; i++) {
            n1 <<= 1;
            n1 += 1;
            n1 <<= 1;
            n2 = n2 << 2;
            n2 += 1;
        }
        print(Integer.toBinaryString(n1));
        print(Integer.toBinaryString(n2));
        print(Integer.toBinaryString(n1^n2));
        print(Integer.toBinaryString(n1&n2));
        print(Integer.toBinaryString(n1|n2));
        print(Integer.toBinaryString(~n1 & n2));

    }
}
