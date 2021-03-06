package com.zjuee.util;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()))) {
            String s;
            while((s=in.readLine())!=null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String filename, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(filename).getAbsoluteFile()
            );
            try {
                out.println(text);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TextFile(String filename, String splitter) {
        super(Arrays.asList(read(filename).split(splitter)));
        if(get(0).equals("")) remove(0);
    }

    public TextFile(String filename) {
        this(filename,"\n");
    }

    public void write(String filename) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(filename).getAbsoluteFile()
            );
            try {
                for(String item : this) {
                    out.println(item);
                }
            }finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("src/com.zjuee.util/TextFile.java");
        write("text.txt", file);
        TextFile text = new TextFile("text.txt");
        text.write("test2.txt");
        // TreeSet会对单词数组进行排序
        TreeSet<String> words = new TreeSet<>(
                new TextFile("text.txt", "\\W+")
        );
        // 输出到a为止
        System.out.println(words.headSet("a"));
    }


}
