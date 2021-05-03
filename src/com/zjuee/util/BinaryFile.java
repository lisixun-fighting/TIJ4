package com.zjuee.util;

import java.io.*;

public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(bFile)
        );
        try {
            byte[] bData = new byte[in.available()];
            in.read(bData);
            return bData;
        } finally {
            in.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile));
    }
}
