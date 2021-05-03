package com.zjuee.generics;

public class GenericMethods {
    public <A,B> void f(A x, B y, Float z) {
        System.out.println(x.getClass().getName() + " " + y.getClass().getName() + " " + z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1,"hello",1.0f);

    }
}
