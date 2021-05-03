package com.zjuee.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        while(buffer.position() + 1 < buffer.capacity()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}
