package com.zjuee.practice.ch5;

import static net.mindview.util.Print.print;

class Book {
    public Book(int n) {
        print("Book(" + n + ")");
    }
}

class Study {
    static Book b2;
    static Book b1 = new Book(1);
    static {
        b2 = new Book(2);
    }
    static void f1() {
        print("f1()");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        Study.f1();
    }
}
