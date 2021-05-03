package com.zjuee.practice.ch9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class RandomChars {
    private static Random rand = new Random();
    public CharSequence next(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) ('a' + rand.nextInt(26)));
        }
        return sb.append('\n').toString();
    }
    public static void main(String[] args) {
        RandomChars randomChars = new RandomChars();
        for (int i = 0; i < 10; i++) {
            System.out.println(randomChars.next(5));
        }
    }
}

class AdaptedRandomChars extends RandomChars implements Readable {

    private int count;
    private int n;
    public AdaptedRandomChars(int count, int n) {
        this.count = count;
        this.n = n;
    }
    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0)
            return -1;
        StringBuilder sb = new StringBuilder();
        sb.append(next(n));
        cb.append(sb);
        return sb.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdaptedRandomChars(5,5));
        while (scanner.hasNext())
            System.out.println(scanner.next());
    }
}

public class Demo02 {
}
