package com.zjuee.practice.ch15;

abstract class Add<T extends Add<T>> {
    T element;
    abstract T run(T t);
    T cal(T t) {
        return run(t);
    }
}

class Alu extends Add<Alu> {
    @Override
    Alu run(Alu alu) {
        return alu;
    }
}

public class Demo07 {

    public static void main(String[] args) {
        Alu a1 = new Alu();
        Alu a2 = new Alu();
        Alu a3 = a1.cal(a2);
    }
}
