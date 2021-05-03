package com.zjuee.practice.ch4;

class Run {
    private int speed;

    public Run(int speed) {
        this.speed = speed+10;
        System.out.println("int args; speed = " + speed);
    }

    public Run() {
        this(10);
        System.out.println("default constructor (no args)");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        new Run();
    }
}
