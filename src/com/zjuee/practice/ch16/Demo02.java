package com.zjuee.practice.ch16;

import com.zjuee.util.Generated;

import java.util.Arrays;

class A implements Comparable<A> {
    private int val;
    public A(int val) {
        this.val = val;
    }
    public int getVal() {
        return val;
    }
    @Override
    public int compareTo(A a) {
        return Integer.compare(val,a.val);
    }
    public String toString() {
        return val + " ";
    }
}

public class Demo02 {
    public static void main(String[] args) {
        A[] a1 = new A[10];
        A[] a2 = new A[10];
        for (int i = 0; i < 10; i++) {
            a1[i] = new A(i);
            a2[i] = new A(i);
        }
        System.out.println(Arrays.equals(a1,a2));
        System.out.println(equal(a1,a2));
    }

    public static boolean equal(A[] l1, A[] l2) {
        if(l1.length != l2.length)
            return false;
        for (int i = 0; i < l1.length; i++) {
            if(l1[i].getVal() != l2[i].getVal())
                return false;
        }
        return true;
    }
}
