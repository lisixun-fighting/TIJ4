package com.zjuee.practice.ch5;

import java.util.Arrays;

import static net.mindview.util.Print.print;

class Node {
    String val;
    public Node(String v) {
        val = v;
    }

    @Override
    public String toString() {
        return val;
    }
}

public class Demo03 {

    public static void main(String[] args) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node("a");
        }
        print(Arrays.toString(nodes));
    }
}
