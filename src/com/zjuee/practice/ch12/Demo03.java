package com.zjuee.practice.ch12;

class A {
    public void f() throws Exception {
        throw new Exception();
    }
}
class B extends A {
    @Override
    public void f() throws Exception {
        throw new RuntimeException();
    }
}
class C extends B {
    @Override
    public void f() throws Exception {
        throw new IndexOutOfBoundsException();
    }
}

public class Demo03 {
    public static void main(String[] args) {
        try {
            A c = new C();
            c.f();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
