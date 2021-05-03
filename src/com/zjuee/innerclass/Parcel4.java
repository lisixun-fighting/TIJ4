package com.zjuee.innerclass;

public class Parcel4 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if(cost > 100)
                    System.out.println("Over budget!");
            }
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Destination dest = p.destination("Tasmania", 101.395f);
        System.out.println(dest.readLabel());
    }
}
