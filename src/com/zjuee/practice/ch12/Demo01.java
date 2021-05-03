package com.zjuee.practice.ch12;

import java.util.Random;

class MyException1 extends Exception {

}

class MyException2 extends Exception {}

class MyException3 extends Exception {}

public class Demo01 {
    public static void main(String[] args) {
        Random rand = new Random();
        try {
            switch (rand.nextInt(3)) {
                case 0:
                    throw new MyException1();
                case 1:
                    throw new MyException2();
                case 2:
                    throw new MyException3();
                default:
                    throw new UnsupportedOperationException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
