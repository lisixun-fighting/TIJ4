package com.zjuee.io;

import java.io.*;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        StringBuffer sb = new StringBuffer();
        String s;
        while((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("src/com.zjuee.chapter18_io/BufferedInputFile.java"));
    }
}
