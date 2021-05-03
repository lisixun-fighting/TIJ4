package com.zjuee.practice.ch18;

import java.io.*;

public class Demo05 {

    public static void testBufferedIO(String fileRead, String fileWrite) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileRead));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileWrite));
        String s;
        long start = System.nanoTime();
        while ((s = reader.readLine()) != null) {
            writer.write(s);
        }
        long end = System.nanoTime();
        System.out.format("BufferedIO cost time %d ns", (end-start));
        reader.close();
        writer.close();
    }

    public static void testFileIO(String fileRead, String fileWrite) throws IOException  {
        FileReader reader = new FileReader(fileRead);
        FileWriter writer = new FileWriter(fileWrite);
        int flag = 0;
        long start = System.nanoTime();
        while ((flag = reader.read()) != -1) {
            writer.write((char)flag);
        }
        long end = System.nanoTime();
        System.out.format("FileIO cost time %d ns", (end-start));
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        testBufferedIO("src/com/zjuee/practice/ch18/testInput.txt","testOutput.txt");
        System.out.println();
        testFileIO("src/com/zjuee/practice/ch18/testInput.txt","testOutput.txt");
    }
}
