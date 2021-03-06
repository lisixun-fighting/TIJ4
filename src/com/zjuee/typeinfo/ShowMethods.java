package com.zjuee.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import static com.zjuee.util.Print.*;

public class ShowMethods {
    private static String usage =
            "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("(\\w+\\.)|(final\\s*)|(native\\s*)");

    public static void main(String[] args) {
        if(args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            if(args.length == 1) {
                for (Method method : methods) {
                    print(p.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor<?> constructor : constructors) {
                    print(p.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            }
        } catch (ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }
}
