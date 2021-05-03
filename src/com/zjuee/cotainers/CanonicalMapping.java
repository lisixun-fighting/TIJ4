package com.zjuee.cotainers;

import java.util.WeakHashMap;

class Element {
    private String ident;
    public Element(String id) { ident = id; }
    public String toString() { return ident; }
    public int hashCode() { return ident.hashCode(); }
    public boolean equals(Object r) {
        return r instanceof Element && ident.equals(((Element) r).ident);
    }
    protected void finalize() {
        System.out.print("Finalizing ");
        System.out.print(getClass().getSimpleName());
        System.out.print(" ");
        System.out.println(ident);
//        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}
class Key extends Element {
    public Key(String id) {
        super(id);
    }
}
class Value extends Key {
    public Value(String id) {
        super(id);
    }
}

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 10;
        if(args.length > 0)
            size = Integer.parseInt(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if(i % 3 == 0)
                keys[i] = k;
            map.put(k, v);
        }
//        System.out.println(map);
        System.gc();
    }
}
