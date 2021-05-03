package com.zjuee.strings;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1, 2, 3, 4, 5");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }
}
