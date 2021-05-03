package com.zjuee.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        Charset charset = Charset.forName(encoding);
        System.out.println("after decoding: " + charset.decode(buffer));


        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes(StandardCharsets.UTF_16BE)));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24);
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
