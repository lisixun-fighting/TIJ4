package com.zjuee.io;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src/com.zjuee.chapter18_io/BasicFileOutput.java")
                )
        );
        /*PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file))
        );*/
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null) {
            out.println(lineCount++ + " " + s);
        }
        out.close();
        in.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
