package com.zjuee.initialization;

class Window {
    public Window(int n) {
        System.out.println("Window(" + n + ")");
    }

    public Window() {
    }
}

class House {
    Window w1 = new Window(1);

    public House() {
        System.out.println("House()");
//        w3 = new Window(33);
    }

    Window w3;

    void f() {
        System.out.println("f()");
    }
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House();
        System.out.println(house.w3);
    }
}
