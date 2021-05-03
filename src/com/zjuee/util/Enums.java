package com.zjuee.util;

import java.util.Random;

enum Activity {
    SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}

public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(random(Activity.class).name() + " ");
        }
    }
}
