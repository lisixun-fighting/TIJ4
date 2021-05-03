package com.zjuee.typeinfo;

import static net.mindview.util.Print.print;

class Candy {
    static {
        print("Loading Candy");
    }
}

class Gum {
    static {
        print("Loading Gum");
    }
}

class Cookie {
    static {
        print("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("after creating candy");
        try {
            Class.forName("com.zjuee.typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forname(\"Gum\")");
        new Cookie();
    }
}
