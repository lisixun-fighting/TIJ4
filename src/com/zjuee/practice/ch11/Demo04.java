package com.zjuee.practice.ch11;

import java.util.LinkedList;
import java.util.Queue;

import static net.mindview.util.Print.print;

class Command {
    String val;

    public Command(String val) {
        this.val = val;
    }

    void operation() {
        print(val);
    }
}

class CommandQueue {
    static Queue<Command> full(Queue<Command> q, Command c) {
        q.offer(c);
        return q;
    }
}

public class Demo04 {
    public static void main(String[] args) {
        Queue<Command> queue = new LinkedList<>();
        CommandQueue.full(queue, new Command("draw"));
        CommandQueue.full(queue, new Command("run"));
        CommandQueue.full(queue, new Command("swim"));
        while(!queue.isEmpty()) {
            queue.poll().operation();
        }
    }
}
