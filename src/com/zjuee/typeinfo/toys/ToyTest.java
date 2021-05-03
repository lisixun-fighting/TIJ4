package com.zjuee.typeinfo.toys;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.mindview.util.Print.print;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Music {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Music {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class<?> cc) {
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("com.zjuee.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class<?> face : c.getInterfaces()) {
            printInfo(face);
        }
        Class<?> up = c.getSuperclass();
        Toy obj = null;
        try {
            obj = (Toy) up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        print(obj);
        printInfo(obj.getClass());

        try {
            c = Class.forName("com.zjuee.typeinfo.toys.Toy");
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
