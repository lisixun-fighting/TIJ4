package com.zjuee.strings;

public class DatabaseException extends Exception {
    public DatabaseException(Object...args) {
        super(String.format("(t%d, q%d) %s", args));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3,5,"write failed");
        } catch (DatabaseException e) {
            System.out.println(e);
        }
    }
}
