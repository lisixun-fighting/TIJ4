package com.zjuee.io;

import java.io.*;
import java.util.*;
public class Practice7 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        List<String> list = new LinkedList<>();
        String s;
        while((s = in.readLine()) != null) {
            s = s.toUpperCase();
            list.add(s);
        }
        in.close();
        Collections.reverse(list);

        int lineCount = 1;
        PrintWriter out = new PrintWriter("Practice7.out");
        for (String s1 : list) {
            out.println(lineCount++ + " " + s1);
        }
        out.close();
        System.out.println(BufferedInputFile.read("Practice7.out"));
    }
}
