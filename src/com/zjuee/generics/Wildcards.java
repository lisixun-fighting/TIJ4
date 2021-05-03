package com.zjuee.generics;

public class Wildcards {
    static void rawArgs(Holder holder, Object arg) {
        Object o = holder.get();
    }

    static void unboundedArgs(Holder<?> holder, Object arg) {
//        holder.set(arg);
        Object o = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> void exact2(Holder<T> holder, T arg) {
        holder.set(arg);
    }

    static <T> T wildSubType(Holder<? extends T> holder) {
        return holder.get();
    }

    static <T> void wildSubType2(Holder<? super T> holder, T arg) {
        holder.set(arg);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArgs(raw, lng);
        unboundedArgs(qualified, lng);
        unboundedArgs(unbounded, lng);
        unboundedArgs(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        exact2(raw, lng);
        exact2(qualified, lng);
//        exact2(unbounded, lng);
//        exact2(bounded, lng);


    }
}
