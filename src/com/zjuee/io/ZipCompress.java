package com.zjuee.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(fos, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");

        for (String arg : args) {
            System.out.println("Writing file: " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while((c=in.read())!=-1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("Checksum: " + csum.getChecksum().getValue());

        System.out.println("Reading file");
        FileInputStream fis = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fis, new Adler32());
        ZipInputStream zis = new ZipInputStream(csumi);
        BufferedInputStream in = new BufferedInputStream(zis);
        ZipEntry ze;
        while((ze=zis.getNextEntry())!=null) {
            System.out.println("Reading file: " + ze);
            int x;
            while((x=in.read())!= -1) {
                System.out.write(x);
            }
        }

        if(args.length == 1) {
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
        }
        in.close();

        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            System.out.println("File: " + ze2);
        }

    }
}
