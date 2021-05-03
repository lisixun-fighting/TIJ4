package com.zjuee.practice.ch4;

import static net.mindview.util.Print.print;

class Dog {

    String name;

    public Dog() {
        System.out.println("Create a Dog " + this);
    }

    public Dog(String name) {
        this.name = name;
        System.out.println("Create a Dog " + name + " " + this);
    }

    void bark(int n) {
        print(name + " is barking");
    }

    void bark(short n) {
        print(name + " is howling");
    }
}

public class Demo01 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog("Spike");

        dog2.bark(1);
        dog2.bark((short) 1);
    }
}
