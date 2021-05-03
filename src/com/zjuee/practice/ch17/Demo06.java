package com.zjuee.practice.ch17;

import com.zjuee.cotainers.AssociativeArray;
import com.zjuee.cotainers.SlowMap;
import com.zjuee.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;

public class Demo06 {
    public static void main(String[] args) {
        Map<String, Integer> map = new SlowMap<>();
        Matcher matcher = Pattern.compile("\\w+").matcher(TextFile.read("F:\\JAVA\\IdeaProjects\\ThinkingInJava\\test.txt"));
        while (matcher.find()){
            String s = matcher.group();
            Integer tmp = map.get(s);
            if(tmp == null)
                map.put(s, 1);
            else
                map.put(s, tmp+1);
        }
        System.out.println(map);
    }
}
