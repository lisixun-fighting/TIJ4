package com.zjuee.practice.ch9;

import static net.mindview.util.Print.print;

public interface Demo04 {
    void f();
    class Test {
        public static void main(String[] args) {
            Demo04 d = new Demo04() {
                public void f() {
                    print("f()");
                }
            };
            ff(d);
        }
        static void ff(Demo04 d) {
            d.f();
        }
    }
}
