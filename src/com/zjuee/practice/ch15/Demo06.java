package com.zjuee.practice.ch15;

class Holder<T> {
    T val;
    public void set(T t) {
        val = t;
    }
    public T get() {
        return val;
    }
}

public class Demo06 {
    public static void main(String[] args) {
        Holder<Integer> holdInt = new Holder<>();
        holdInt.set(1);
        int res = holdInt.get();
        System.out.println(res);

        Holder<Character> holdChar = new Holder<>();
        holdChar.set('c');
        char res2 = holdChar.get();
        System.out.println(res2);

        Holder<Short> holdShort = new Holder<>();
        Holder<Long> holdLong = new Holder<>();
        Holder<Float> holdFloat = new Holder<>();

    }
}
