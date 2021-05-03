package com.zjuee.generics;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassCasting {
    public void f(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<?> list = List.class.cast(in.readObject());
    }
}
