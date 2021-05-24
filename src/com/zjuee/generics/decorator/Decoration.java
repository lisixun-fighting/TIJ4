package com.zjuee.generics.decorator;

import java.util.Date;

class Basic {
    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
}

class Decorator extends Basic {
    protected Basic basic;
    public Decorator(Basic basic) {
        this.basic = basic;
    }
    public void set(String val) {
        basic.set(val);
    }
    public String get() {
        return basic.get();
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;
    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumbered extends Decorator {
    private static int counter = 0;
    private final int serialNumber = counter++;
    public SerialNumbered(Basic basic) {
        super(basic);
    }
    public int getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));

    }
}
