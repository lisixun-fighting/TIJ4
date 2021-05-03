package com.zjuee.cotainers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Associative keys with values
public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    public void put(K key, V value) {
        if(index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if(key.equals(pairs[i][0]))
                return (V)pairs[i][1];
        }
        return null;
    }public void set(K key, V val) {
        int find = -1;
        for (int i = 0; i < index; i++) {
            if(key.equals(pairs[i][0]))
                find = i;
        }
        if(find >= 0)
            pairs[find][1] = val;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < index; i++) {
            sb.append(pairs[i][0].toString());
            sb.append(":");
            sb.append(pairs[i][1].toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");
        try {
            map.put("extra","object");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
        System.out.println(map.get("age"));
    }
}
