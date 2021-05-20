package com.zjuee.practice.ch21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class ThreadMethod {
    private String name;
    private static ExecutorService exec = Executors.newCachedThreadPool();
    public ThreadMethod(String name) {
        this.name = name;
    }
    public Future<Integer> runTask(int n) {
        return exec.submit(new Callable<>() {
            @Override
            public Integer call() {
                return fib(n);
            }
            private int fib(int n) {
                if (n < 2) return 1;
                return fib(n - 1) + fib(n - 2);
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadMethod fibonacci = new ThreadMethod("Fibonacci");
        List<Future<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(fibonacci.runTask(i));
        }
        for (Future<Integer> fb : res) {
            if (fb.isDone())
                System.out.println(fb.get());
        }
        ThreadMethod.exec.shutdown();
    }
}

public class DemoThreadTask {
    public static void main(String[] args) {

    }
}
