package com.zjuee.generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

public class SelfBoundingAndCovariantArguments {
    void test(Setter s1, Setter s2, SelfBoundSetter<Setter> sbs) {
        s1.set(s1);
        s2.set(s2);
//        s1.set(sbs);
    }
}
