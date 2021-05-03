package com.zjuee.practice.ch18;

import com.zjuee.util.TextFile;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        File path = new File("./src/com/zjuee/io");
        String[] list = path.list((dir, name) -> {
            if(name.matches(".*\\.java")) {
                String read = TextFile.read(dir + "/" + name);
                if (args.length > 0)
                    return read.contains(args[0]);
                return true;
            }
            return false;
        });
        System.out.println(Arrays.toString(list));

        int size = 0;
        for (String filename : path.list()) {
            filename = path + "/" +filename;
            File file = new File(filename);
            if(file.isDirectory())
                continue;
            size += TextFile.read(filename).length();
        }
        System.out.println(size);
    }
}
