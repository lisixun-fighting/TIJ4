package com.zjuee.practice.ch17;

import com.zjuee.cotainers.AssociativeArray;
import com.zjuee.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo05 {
    public static void main(String[] args) {
        AssociativeArray<String, Integer> map = new AssociativeArray<>(100);
        Matcher matcher = Pattern.compile("\\w+").matcher(TextFile.read("F:\\JAVA\\IdeaProjects\\ThinkingInJava\\test.txt"));
        while (matcher.find()){
            String s = matcher.group();
            Integer tmp = map.get(s);
            if(tmp == null)
                map.put(s, 1);
            else
                map.set(s, tmp+1);
        }
        System.out.println(map);
    }
}
