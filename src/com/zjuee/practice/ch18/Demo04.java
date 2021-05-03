package com.zjuee.practice.ch18;

import com.zjuee.io.BufferedInputFile;

import java.io.*;
import java.util.*;
public class Demo04 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        List<String> list = new LinkedList<>();
        String s;
        while((s = in.readLine()) != null)
            list.add(s.toUpperCase());
        in.close();
        Collections.reverse(list);

        int lineCount = 1;
        PrintWriter out = new PrintWriter("Practice7.out");
        for (String s1 : list) {
            out.println(lineCount++ + " " + s1);
        }
        out.close();
    }
}
