package com.zjuee.practice.ch18;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

class SortedDirList {
    public static List<String> list(String path) {
        return List.of(new File(path).list());
    }

    public static List<String> list(String path, String regex) {
        return Arrays.stream(new File(path).list()).filter(name -> name.matches(regex)).collect(Collectors.toList());
    }
}

public class Demo02 {

    public static void main(String[] args) {
        System.out.println(SortedDirList.list("."));
        System.out.println(SortedDirList.list(".", "^.\\w+$"));
    }
}
