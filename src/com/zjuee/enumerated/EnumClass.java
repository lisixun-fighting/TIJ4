package com.zjuee.enumerated;

enum Shrubbery { GROUND, CRAWLING, HANGING }

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-----------------");
        }
    }
}
