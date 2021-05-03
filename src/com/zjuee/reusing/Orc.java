package com.zjuee.reusing;

import static net.mindview.util.Print.print;

class Villain {
    private String name;

    protected Villain(String name) {
        this.name = name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I am a villain and my name is " + name;
    }
}

public class Orc extends Villain {

    private int number;

    protected Orc(String name, int number) {
        super(name);
        this.number = number;
    }

    public void change(String name, int number) {
        super.setName(name);
        this.number = number;
    }

    @Override
    public String toString() {
        return "Orc " + number + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
}
