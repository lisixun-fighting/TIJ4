package com.zjuee.cotainers;

public class Groundhog {
    protected int number;
    public Groundhog(int n) { number = n; }
    public int hashCode() {
        return number;
    }
    public boolean equals(Object o) {
        return o instanceof Groundhog && (number == ((Groundhog)o).number);
    }
    public String toString() {
        return "Groundhog#" + number;
    }
}