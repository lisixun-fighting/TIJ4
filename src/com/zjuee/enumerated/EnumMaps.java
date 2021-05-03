package com.zjuee.enumerated;

import java.util.*;

import static com.zjuee.enumerated.AlarmPoints.*;

interface Command { void action(); }

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Bathroom alert!");
            }
        });
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen fire!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()){
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
        for (AlarmPoints key : em.keySet()) {
            System.out.println(key);
        }
        try {
            em.get(UTILITY).action();
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
