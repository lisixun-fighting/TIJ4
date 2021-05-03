package com.zjuee.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.compile(regex).matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File("src/com.zjuee.chapter18_io/");
        String[] list;
        if(args.length == 0) {
            list = path.list();
        }else {
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
