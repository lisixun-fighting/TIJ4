package com.zjuee.io.xfiles;

import com.zjuee.io.Alien;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"));
        out.writeObject(new Alien());
    }
}
