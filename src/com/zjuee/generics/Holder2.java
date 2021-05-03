package com.zjuee.generics;

public class Holder2 {
    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile)h2.getA();
        h2.setA("Not an Automobile");
        String s = (String) h2.getA();
        h2.setA(1);
        Integer i = (Integer) h2.getA();
    }
}
