package com.zjuee.innerclass;

public class Parcel3 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;
            public PDestination(String label) {
                this.label = label;
            }
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public Contents contents() {
        return new Contents() {
            int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public Destination destination2(String s) {
        return new Destination() {
            private final String label = s;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
