package com.zjuee.practice.ch8;

import static net.mindview.util.Print.print;

class AlertStatus {
    void notice() {}
}

class Warning extends AlertStatus {
    @Override
    void notice() {
        print("Warning");
    }
}

class Healthy extends AlertStatus {
    @Override
    void notice() {
        print("Healthy");
    }
}

class SpaceShip {
    private AlertStatus status;
    public SpaceShip(AlertStatus status) {
        this.status = status;
    }
    public void change(AlertStatus status) {
        this.status = status;
    }
    public void how() {
        status.notice();
    }
}

public class Demo02 {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip(new Healthy());
        spaceShip.how();
        spaceShip.change(new Warning());
        spaceShip.how();
    }
}
