package com.zjuee.practice.ch6;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Connection[] connections = ConnectionManager.getConnections();
        System.out.println(Arrays.toString(connections));
        connections = ConnectionManager.getConnections();
        System.out.println(Arrays.toString(connections));
    }
}
