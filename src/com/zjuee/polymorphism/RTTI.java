package com.zjuee.polymorphism;

import static net.mindview.util.Print.print;

class Useful {
    public void f() {}
}

class MoreUseful extends Useful {
    public void g() {
        print("g()");
    }
}

public class RTTI {
    public static void main(String[] args) {
        Useful u1 = new Useful();
        Useful u2 = new MoreUseful();
        try {
            MoreUseful u3 = (MoreUseful) u2;
            u3.g();
            MoreUseful u4 = (MoreUseful) u1;
            u4.g();
        } catch (ClassCastException e) {
            print(e);
        }
    }
}
