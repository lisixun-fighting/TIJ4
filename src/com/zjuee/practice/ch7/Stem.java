package com.zjuee.practice.ch7;

class Component {
    static int count = 0;
    int id;
    public Component() {
        id = count++;
        System.out.println("Component Constructor " + id);
    }
}

class Root {
    Component component1;
    Component component2;
    public Root(int id) {
        System.out.println("Root Constructor");
        component1 = new Component();
        component2 = new Component();
    }
}

public class Stem extends Root {
    Component component1;
    Component component2;

    public Stem(int id) {
        super(1);
        System.out.println("Stem Constructor");
        component1 = new Component();
        component2 = new Component();
    }

    public static void main(String[] args) {
        new Stem(1);
    }
}
