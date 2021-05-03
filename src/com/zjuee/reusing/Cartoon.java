package com.zjuee.reusing;

import static net.mindview.util.Print.print;

class Art {
    Art() {
        print("Art constructor");
    }
}

public class Cartoon extends Art {
    String getSuper() {
        System.out.println(this);
        return super.toString();
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
        System.out.println(cartoon);
        System.out.println(cartoon.getSuper());
    }
}
