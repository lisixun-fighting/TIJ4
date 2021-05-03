package com.zjuee.typeinfo.interfacea;

class B implements A {
    public void f(){
        System.out.println("B.f()");
    };
    public void g(){
        System.out.println("B.g()");
    };
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if(a instanceof B){
            B b = (B) a;
            b.g();
        }
    }
}
