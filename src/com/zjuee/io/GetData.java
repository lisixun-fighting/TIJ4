package com.zjuee.io;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

        int i = 0;
        while(i++ < buffer.limit()) {
            if (buffer.get() != 0) System.out.print("nozero");
        }
        System.out.print("i = " + i);
        System.out.println();
        buffer.rewind();

        buffer.asCharBuffer().put("Howdy!");
        char c;
        while((c=buffer.getChar())!=0) {
            System.out.print(c + " ");
        }
        System.out.println();

        buffer.rewind();
        buffer.asShortBuffer().put((short) 471142);



        System.out.println(buffer.getShort());

        buffer.rewind();
        buffer.asIntBuffer().put((int) 99471142);
        System.out.println(buffer.getInt());

    }
}
