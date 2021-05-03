package com.zjuee.innerclass;

public class Parcel2 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        Contents c = p.new Contents();
        Destination d = p.new Destination("Xi'an");
        System.out.println(d.readLabel());
    }
}

