package com.zjuee.access;

class Soup1 {
    private Soup1() {}
    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {}
    private static Soup2 soup2 = new Soup2();
    public static Soup2 getSoup() {
        return soup2;
    }
}

public class Lunch {
    public static void main(String[] args) {
        Soup1 soup1 = Soup1.makeSoup();
        Soup2 soup2 = Soup2.getSoup();
    }
}
