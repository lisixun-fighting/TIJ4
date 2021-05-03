package com.zjuee.strings;

import com.zjuee.util.BinaryFile;

import java.io.IOException;

public class Hex {

    public static String format(byte[] data) {
        StringBuilder res = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if(n % 16 == 0)
                res.append(String.format("%04X:", n));
            res.append(String.format(" %02X",b));
            n++;
            if(n % 16 == 0) res.append("\n");
        }
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                format(BinaryFile.read("src/com/zjuee/strings/Hex.java")));
    }
}
