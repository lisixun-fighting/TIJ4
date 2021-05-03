package com.zjuee.enumerated;

import java.util.EnumSet;

public class CarWash {
    public enum Cycle {
        UNDERBODY {
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEELWASH {
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        PREWASH {
            void action() {
                System.out.println("Loosening the dirt");
            }
        },
        BASIC {
            void action() {
                System.out.println("The basic wash");
            }
        },
        HOTWAX {
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        RINSE {
            void action() {
                System.out.println("Rinsing");
            }
        };
        abstract void action();
    }
    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE, Cycle.UNDERBODY);
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar() {
        for (Cycle cycle : cycles)
            cycle.action();
    }
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar();
        System.out.println(carWash);
    }
}
