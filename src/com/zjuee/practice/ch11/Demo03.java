package com.zjuee.practice.ch11;

import com.zjuee.util.TextFile;
import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        String[] words = TextFile.read("src/com/zjuee/practice/ch11/Demo03.java").split("\\W+");
        Map<String, ArrayList<Integer>> m = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> list = m.get(words[i]);
            if(list == null) list = new ArrayList<>();
            m.put(words[i], list);
            list.add(i);
        }
        System.out.println(m);
    }
}
