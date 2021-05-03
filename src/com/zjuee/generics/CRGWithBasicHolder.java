package com.zjuee.generics;

class Subtype extends BasicHolder<Subtype> {

}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype();
        Subtype st2 = new Subtype();
        st1.set(st2);
        st2.set(st1);
        st1.f();
        Subtype st3 = st1.get();
        st3.f();
    }
}
