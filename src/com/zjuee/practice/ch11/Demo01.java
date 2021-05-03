package com.zjuee.practice.ch11;

import com.zjuee.util.Stack;

public class Demo01 {
    public static String resolver(String src) {
        char[] chars = src.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '+') {
                stack.push(chars[++i]);
            }
            else if(chars[i] == '-') {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.empty())
            res.append(stack.pop());
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(resolver("+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s--"));
    }
}
