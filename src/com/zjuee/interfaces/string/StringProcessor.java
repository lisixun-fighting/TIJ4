package com.zjuee.interfaces.string;

import java.util.Arrays;

interface Strategy {
    String process(String s);
}

class Reverse implements Strategy {

    @Override
    public String process(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length-1; j > i; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chars)
            sb.append(ch);
        return sb.toString();
    }
}

public class StringProcessor {

    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Strategy strategy, String s) {
        return strategy.process(s);
    }
}
