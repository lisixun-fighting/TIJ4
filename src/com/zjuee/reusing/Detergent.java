package com.zjuee.reusing;

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

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        print(x);
    }
}

public class Detergent extends Cleanser {
    public void dilute() {
        append("Detergent ");
        super.dilute();
    }
    public void apply() {
        append("Detergent ");
        super.dilute();
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        print(x);
    }
}
