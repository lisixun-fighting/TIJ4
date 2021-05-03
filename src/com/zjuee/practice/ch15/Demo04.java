package com.zjuee.practice.ch15;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Demo04 {
    static <T> T create(Class<T> type) {
        try {
            Constructor<T> constructor = type.getConstructor(Integer.class);
            return constructor.newInstance(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        String s = create(String.class);
//        System.out.println(s);

        MyObj myObj = create(MyObj.class);
        System.out.println(myObj);

    }
}
