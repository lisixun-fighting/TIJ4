package com.zjuee.exceptions;

public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("src/com/zjuee/exceptions/Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    System.out.println(s);
                }
            } catch (Exception e) {
                System.out.println("Caught exception in Main()");
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
