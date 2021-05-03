package com.zjuee.practice.ch6;

class Connection {
    private Connection() {}
    static Connection conn() {
        return new Connection();
    }
}

public class ConnectionManager {
    static Connection[] connections = null;
    static {
        connections = new Connection[5];
        for (int i = 0; i < 5; i++) {
            connections[i] = Connection.conn();
        }
    }
    public static Connection[] getConnections() {
        return connections;
    }
}
