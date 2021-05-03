package com.zjuee.generics;

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {
}

public class GenericAndReturnTypes {
    void test(Getter g) {
        Getter getter = g.get();
        GenericGetter<Getter> getter1 = g.get();
    }
}
