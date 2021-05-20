package com.zjuee.practice.ch21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Fibonacci implements Callable<String> {
    private static int count = 0;
    private final int id;
    private int nums;
    public Fibonacci(int nums) {
        id = count++;
        this.nums = nums;
    }

    public String call() {
        return "result of Fibonacci " + id + " is " + fib(nums);
    }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}

public class Demo02 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(executor.submit(new Fibonacci(i)));
        }
        for (Future<String> fs : res) {
            try {
                System.out.println(fs + " is Done ? " + fs.isDone());
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e);
            } finally {
                executor.shutdown();
            }
        }
    }
}
