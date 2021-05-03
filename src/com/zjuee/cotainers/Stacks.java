package com.zjuee.cotainers;

import java.util.*;

enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER }

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values())
            stack.push(m.name());
        System.out.println(stack);
        stack.add("The last line");
        System.out.println(stack.elementAt(5));
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}
