package com.zjuee.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("X.file"));
        Object obj = in.readObject();
        System.out.println(obj.getClass().getSimpleName());
    }
}
