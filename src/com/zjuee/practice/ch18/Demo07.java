package com.zjuee.practice.ch18;

import java.io.*;
import java.util.List;

class Apple implements Serializable {

}

class Pear implements Serializable {
    Apple a;
    public Pear(Apple a) {
        this.a = a;
    }
}

public class Demo07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/com/zjuee/practice/ch18/fruit.txt"));
//        out.writeObject(new Pear(new Apple()));
        out.writeObject(List.of(new Apple(), new Apple()));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/com/zjuee/practice/ch18/fruit.txt"));
//        Pear pear = (Pear) in.readObject();
//        System.out.println(pear);
//        System.out.println(pear.a);
        List<?> list = (List<?>) in.readObject();
        for (Object obj : list) {
            System.out.println(obj.getClass());
        }
    }
}
