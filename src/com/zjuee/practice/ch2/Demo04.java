package com.zjuee.practice.ch2;

import static net.mindview.util.Print.print;

public class Demo04 {
    public static void main(String[] args) {
        int num = 0x7fffffff;
        while (num > 0) {
            print(Integer.toBinaryString(num));
            num >>= 1;
        }
        print();
        num = 0x80000000;
        do {
            num >>= 1;
            print(Integer.toBinaryString(num));
        } while (num < -1);
        print();

        num = 0xffffffff;
        num <<= 1;
        print(Integer.toBinaryString(num));
        while (num != 0) {
            num >>>= 1;
            print(Integer.toBinaryString(num));
        }
        print();

        for (int i = 0; i < 26; i++) {
            char tmp = (char)('a'+i);
            print(tmp+": ");
            char2Binary(tmp);
        }
    }

    static void char2Binary(char ch) {
        StringBuilder sb = new StringBuilder();
        while (ch > 0) {
            sb.append(ch%2);
            ch >>= 1;
        }
        System.out.println(sb.reverse().toString());
    }
}
