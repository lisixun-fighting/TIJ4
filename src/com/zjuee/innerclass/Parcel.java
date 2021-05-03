package com.zjuee.innerclass;

public class Parcel {
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
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }
    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.ship("Tasmania");
        Parcel q = new Parcel();
        Parcel.Contents c = q.contents();
        Parcel.Destination d = q.to("Borneo");
        System.out.println(d.readLabel());;
    }
}

