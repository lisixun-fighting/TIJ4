package com.zjuee.util;

import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<T>();
    public void addFirst(T t) {
        deque.addFirst(t);
    }
    public void addLast(T t) {
        deque.addLast(t);
    }
    public T getFirst() {
        return deque.getFirst();
    }
    public T getLast() {
        return deque.getLast();
    }
    public T removeFirst() {
        return deque.removeFirst();
    }
    public T removeLast() {
        return deque.removeLast();
    }
    public int size() {
        return deque.size();
    }
    public String toString() {
        return deque.toString();
    }
}
