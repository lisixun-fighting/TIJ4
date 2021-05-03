package com.zjuee.operators;

import static net.mindview.util.Print.print;

public class Literals {
    public static void main(String[] args) {
        print(Integer.toBinaryString(2000));
        print(Integer.toHexString(2000));
        print(Integer.lowestOneBit(20));
        print(Integer.bitCount(2000));
    }
}
