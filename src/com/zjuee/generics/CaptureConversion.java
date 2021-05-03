package com.zjuee.generics;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder){
        f1(holder);  // 使用捕获
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw); // 捕获

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);

        Holder<?> wildCarded = new Holder<Double>(1.0);
        f2(wildCarded);
    }
}
