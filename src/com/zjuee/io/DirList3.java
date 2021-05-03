package com.zjuee.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File path = new File("src/com.zjuee.chapter18_io/");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            // 匿名内部类
            list = path.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return Pattern.compile(args[0]).matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
