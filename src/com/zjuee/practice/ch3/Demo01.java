package com.zjuee.practice.ch3;

import java.util.Random;

import static net.mindview.util.Print.print;

public class Demo01 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            int tmp = rand.nextInt(10);
            switch (tmp) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    print(tmp + " < 5");
                    break;
                default:
                    print(tmp + " >= 5");
            }
        }
    }
}
