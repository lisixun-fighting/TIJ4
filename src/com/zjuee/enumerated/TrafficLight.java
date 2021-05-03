package com.zjuee.enumerated;

import static com.zjuee.enumerated.Signal.*;

public class TrafficLight {
    Signal color;
    public TrafficLight(Signal color) {
        this.color = color;
    }
    public void change() {
        switch (color) {
            case RED:   color = Signal.GREEN;
                        break;
            case GREEN: color = Signal.YELLOW;
                        break;
            case YELLOW:color = Signal.RED;
                        break;
        }
    }
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight(RED);
        for (int i = 0; i < 8; i++) {
            t.change();
            System.out.println(t);
        }
    }
}
