package com.zjuee.io;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock f1 = fos.getChannel().tryLock();
        if(f1 != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(1000);
            f1.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
