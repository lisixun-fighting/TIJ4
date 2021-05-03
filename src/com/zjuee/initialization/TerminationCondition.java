package com.zjuee.initialization;

class Book {
    boolean checkedOut = false;

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if(checkedOut)
            System.out.println("Error: checked out");
        else
            System.out.println("Successfully cleared");
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        Book dictionary = new Book(true);
        System.gc();
    }
}
