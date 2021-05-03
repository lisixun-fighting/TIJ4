package com.zjuee.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Mime {
    public void walk() {}
    public void sit() {
        System.out.println("Pretending to sit");
    }
    public void push() {}
    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce() {}
}

class CommunicateReflectively {
    public static void Perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.Perform(new SmartDog());
        CommunicateReflectively.Perform(new Mime());
        CommunicateReflectively.Perform(new Robot());
    }
}
