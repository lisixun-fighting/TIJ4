package com.zjuee.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("src/com.zjuee.chapter18_io/FormattedMemoryInput.java").getBytes()));
            while(true) {
                System.out.print((char)in.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
