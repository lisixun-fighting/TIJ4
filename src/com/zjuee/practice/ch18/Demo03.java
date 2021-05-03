package com.zjuee.practice.ch18;

import com.zjuee.util.ProcessFiles;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo03 {
    public static void main(String[] args) throws ParseException {
        File file = new File("Demo03.java");
        System.out.println(file);
        DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date(file.lastModified())));
    }
}
