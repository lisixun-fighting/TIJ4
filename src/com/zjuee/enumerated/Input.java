package com.zjuee.enumerated;

import java.util.*;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;
    Input(int value) {
        this.value = value;
    }
    Input() {}
    int amount() {
        return value;
    }
    static Random rand = new Random();
    public static Input randomSelection() {
        return values()[rand.nextInt(values().length)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(randomSelection());
        }
    }
}
