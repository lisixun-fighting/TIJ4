package com.zjuee.cotainers;

import com.zjuee.util.Countries;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs((key.hashCode()) % SIZE);
        if(buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K,V> me = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                found = true;
                it.set(me);
                break;
            }
        }
        if(!found)
            buckets[index].add(me);
        else
            System.out.println("conflict");
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs((key.hashCode()) % SIZE);
        if(buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index]) {
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        }
        return null;
    }
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if(bucket == null) continue;
            for (MapEntry<K, V> iPair : bucket)
                set.add(iPair);
        }
        return set;
    }
    public void clear() {
        for (LinkedList<MapEntry<K, V>> list : buckets)
            if(list != null)
                list.clear();
    }
    public boolean remove(Object key, Object value) {
        int index = Math.abs((key.hashCode()) % SIZE);
        if(buckets[index] == null)
            return false;
        ListIterator<MapEntry<K,V>> it = buckets[index].listIterator();
        while(it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals());
        System.out.println(m);
        m.clear();
        System.out.println(m);
        m.putAll(Countries.capitals());
        System.out.println(m);
        System.out.println(m.get("GERMANY"));
//        System.out.println(m.entrySet());
    }
}
