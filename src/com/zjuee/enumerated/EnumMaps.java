package com.zjuee.enumerated;

import java.util.*;

import static com.zjuee.enumerated.AlarmPoints.*;

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Runnable> em = new EnumMap<>(AlarmPoints.class);
        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));
        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));
        for (Map.Entry<AlarmPoints, Runnable> e : em.entrySet()){
            System.out.print(e.getKey() + ": ");
            e.getValue().run();
        }
        try {
            em.get(UTILITY).run();
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
