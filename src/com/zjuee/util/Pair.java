package com.zjuee.util;

// 键值对
public class Pair<K,V> {
    public final K key;
    public final V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
