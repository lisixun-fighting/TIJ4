package com.zjuee.practice.ch7;

import static net.mindview.util.Print.print;

class Cleanser {
    protected String s = "cleanser ";
    public void append(String a) { s += a; }
    public void dilute() {
        append("dilute() ");
    }
    public void apply() {
        append("apply() ");
    }

    @Override
    public String toString() {
        return s;
    }
}

class Detergent{

    Cleanser c = new Cleanser();

    public void dilute() {
        c.append("Detergent ");
        c.dilute();
    }
    public void apply() {
        c.append("Detergent ");
        c.apply();
    }

    @Override
    public String toString() {
        return c.toString();
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        print(x);
    }
}

public class Demo02 {
}
