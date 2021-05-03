package com.zjuee.generics;

import com.zjuee.typeinfo.pets.Cat;
import com.zjuee.typeinfo.pets.Dog;
import com.zjuee.typeinfo.pets.Pet;
import com.zjuee.typeinfo.pets.Rodent;

public class Holder3<T> {
    private T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public Holder3(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
        Automobile a = h3.getA();

        Holder3<Pet> h31 = new Holder3<>(new Cat());
        h31 = new Holder3<>(new Dog());
        h31 = new Holder3<>(new Rodent());
    }
}
