package com.zjuee.practice.ch3;

import java.util.Arrays;

import static net.mindview.util.Print.print;

public class Demo02 {
    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            int[] bits = new int[] {i%10, i/10%10, i/100%10, i/1000};
//            print(Arrays.toString(bits));
            outer:
            for (int j0 = 0; j0 < 4; j0++) {
                for (int j1 = 0; j1 < 4; j1++) {
                    if(j1 == j0) continue;
                    for (int j2 = 0; j2 < 4; j2++) {
                        if(j2 == j0 || j2 == j1) continue;
                        for (int j3 = 0; j3 < 4; j3++) {
                            if(j3 == j0 || j3 == j1 || j3 == j2) continue;
                            int tmp1 = bits[j0]*10 + bits[j1];
                            int tmp2 = bits[j2]*10 + bits[j3];
                            if(tmp1*tmp2 == i) {
                                print(tmp1 + " * " + tmp2 + " = " + i);
                                break outer;
                            }
                        }
                    }
                }
            }
        }
    }
}
