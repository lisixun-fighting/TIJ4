package com.zjuee.interfaces.filter;

public class Waveform {
    private static int counter;
    private final int id = counter++;
    public String toString() {
        return "Waveform " + id;
    }
}
