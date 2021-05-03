package com.zjuee.reusing;

import static net.mindview.util.Print.print;

class WithFinals {
    private void f() {
        print("WithFinals.f()");
    }

    private final void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {

    public void f() {
        print("OverridingPrivate.f()");
    }

    public final void g() {
        print("OverridingPrivate.g()");
    }

}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate op = new OverridingPrivate();
        op.f();
        op.g();
        WithFinals wf = new OverridingPrivate();

    }
}
