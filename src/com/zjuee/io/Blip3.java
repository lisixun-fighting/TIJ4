package com.zjuee.io;

import java.io.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3() {
        System.out.println("Blip3 Constructor");
    }
    public Blip3(int i, String s) {
        System.out.println("Blip3(int i, String s)");
        this.i = i;
        this.s = s;
    }
    public String toString() {
        return s + i;
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        // You must do this
        out.writeObject(s);
        out.writeInt(i);
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip3 b3 = new Blip3(47,"A String ");
        System.out.println(b3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("blip3.out"));
        System.out.println("saving object");
        out.writeObject(b3);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("blip3.out"));
        System.out.println("Recovering object");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
