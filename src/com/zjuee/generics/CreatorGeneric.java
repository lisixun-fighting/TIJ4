package com.zjuee.generics;

abstract class GenericWithCreate<T> {
    final T element;
    public GenericWithCreate() {
        element = creat();
    }
    abstract T creat();
}

class X {}

class Creator extends GenericWithCreate<X> {
    @Override
    X creat() {
        return new X();
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
