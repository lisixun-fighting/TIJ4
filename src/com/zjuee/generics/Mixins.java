package com.zjuee.generics;

import java.util.Date;

interface TimeStamped { long getStamp(); }

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered { long getSerialNumber(); }

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface IColored { String color(); }

class ColoredImp implements IColored {
    public String color() {
        return "yellow";
    }
}

interface Basic {
    void set(String val);
    String get();
}

class BasicImp implements Basic {
    private String value;
    public void set(String val) {
        value = val;
    }
    public String get() {
        return value;
    }
}

/**
 * static proxy
 */
public class Mixins extends BasicImp implements TimeStamped, SerialNumbered {
    private final TimeStamped timeStamp = new TimeStampedImp();
    private final SerialNumbered serialNumbered = new SerialNumberedImp();
    public Mixins() {}
    public long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }
    public long getStamp() {
        return timeStamp.getStamp();
    }
    public static void main(String[] args) {
        Mixins mixins1 = new Mixins(), mixins2 = new Mixins();
        mixins1.set("test string 1");
        mixins2.set("test string 2");
        System.out.println(mixins1.getStamp() + " " + mixins1.getSerialNumber());
    }
}
