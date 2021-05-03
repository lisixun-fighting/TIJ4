package com.zjuee.io;

import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;
    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }
    public String toString() {
        return a + "\n" + b;
    }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
//        stream.writeObject(b);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
//        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("test1", "test2");
        System.out.println("Before:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        // 将目标对象写进buf流中
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(sc);
        // 从buf流中读取字节数组，再从字节数组中读取目标对象
        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + sc2);
    }
}
