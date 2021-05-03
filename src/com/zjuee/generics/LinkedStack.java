package com.zjuee.generics;

public class LinkedStack<T> {
    private class Node {
        T item;
        Node next;
        Node() { item = null; next = null;}
        Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
        boolean end() { return item == null && next == null; };
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        top = top.next;
        return result;
    }

    public T peek() {
        return top.item;
    }

    public boolean isEmpty() {
        return top.end();
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        lss.push(null);
        while(!lss.isEmpty()){
            System.out.println(lss.pop());
        }
    }
}
