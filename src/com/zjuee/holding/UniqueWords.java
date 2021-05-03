package com.zjuee.holding;

import com.zjuee.util.TextFile;

import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(new TextFile("src/com/zjuee/holding/UniqueWords.java", "\\W+"));
        System.out.println(words);
        ArrayList<String> wList = new ArrayList<>(words);
        int[] vowels = new int[words.size()];
        int res = 0;
        List<Character> ch = Arrays.<Character>asList('a', 'e', 'i', 'o','u','A','E','I','O','U');

        for (int i = 0; i < wList.size(); i++) {
            String word = wList.get(i);
            for (int j = 0; j < word.length(); j++) {
                if(ch.contains(word.charAt(j)))
                    vowels[i]++;
            }
            res += vowels[i];
        }
        System.out.println(Arrays.toString(vowels));
    }
}
