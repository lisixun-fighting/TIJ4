package com.zjuee.reusing;

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.print;

class Value {
    final int id;
    final static int count = 10;
    final int[] a = {1,2,3,4};
    static Random rand = new Random();
    public Value() {
        id = count + rand.nextInt(10);
    }
}

public class FinalData {
    public static void main(String[] args) {
        Value v1 = new Value();
        print(v1.id);
        print(Value.count);
        print(Arrays.toString(v1.a));
        v1.a[0] = 4;
        print(Arrays.toString(v1.a));

        Value v2 = new Value();
        print(v2.id);
        print(Value.count);
    }
}
