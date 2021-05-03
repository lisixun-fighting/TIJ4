package com.zjuee.initialization;

import com.zjuee.typeinfo.interfacea.A;

class Person {
    public void eat(Apple apple) {
        Apple peeled = Peeler.peel(apple);
        System.out.println("Apple" + apple.val + " is Yummy~");
    }
}

class Peeler {
    public static Apple peel(Apple apple) {
        return apple.getPeeled(apple);
    }
}

class Apple {

    static int id = 0;

    int val;
    boolean isPeeled = false;

    public Apple() {
        val = id++;
    }

    public Apple getPeeled(Apple apple) {
        isPeeled = true;
        return this;
    }

}

public class PassingThis {
    public static void main(String[] args) {
        Apple apple = new Apple();
        new Person().eat(apple);
    }
}
