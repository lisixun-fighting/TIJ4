package com.zjuee.practice.ch18;

import com.zjuee.util.TextFile;
import java.util.*;

public class Demo06 {
    public static void main(String[] args) {
        String read = TextFile.read("src/com/zjuee/practice/ch18/testInput.txt");
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < read.length(); i++) {
            map.merge(read.charAt(i), 1, Integer::sum);
        }
        System.out.println(map);
    }
}
