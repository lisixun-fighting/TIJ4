package com.zjuee.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String> {
    private final int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    public String call() {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results) {
            try {
                System.out.println(fs + " is Done ? " + fs.isDone());
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
