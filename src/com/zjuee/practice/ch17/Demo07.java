package com.zjuee.practice.ch17;

import com.zjuee.cotainers.MapEntry;
import com.zjuee.util.Countries;

import java.util.*;

class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }
    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    private Set<Entry<K, V>> entries = new AbstractSet<>() {
        class MyEntry implements Map.Entry<K, V> {
            int index = -1;
            public K getKey() {
                return keys.get(index);
            }
            public V getValue() {
                return values.get(index);
            }
            public V setValue(V value) {
                return values.set(index, value);
            }
            public String toString() {
                return getKey() + "=" + getValue();
            }
        }
        MyEntry entry = new MyEntry();
        public Iterator<Entry<K, V>> iterator() {
            entry.index = -1;
            return new Iterator<>() {
                public boolean hasNext() {
                    return entry.index < size() - 1;
                }
                public Entry<K, V> next() {
                    entry.index++;
                    return entry;
                }
            };
        }
        public int size() {
            return keys.size();
        }
    };
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }
}

public class Demo07 {
    public static void main(String[] args) {
        SlowMap<String,String> map = new SlowMap<>();
        map.putAll(Countries.capitals(5));
        System.out.println(map);
        System.out.println(map.get("EGYPT"));
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> it = entries.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
