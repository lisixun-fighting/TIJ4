package com.zjuee.util;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    public CountingMapData(int size) {
        if(size < 0)
            this.size = 0;
        this.size = size;
    }
    private static class Entry implements Map.Entry<Integer,String> {
        // ฯํิช
        int index;
        public Entry(int index) {
            this.index = index;
        }
        public boolean equals(Object o) {
            if(o instanceof Integer)
                return Integer.valueOf(index).equals(o);
            return false;
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
        public Integer getKey() {
            return index;
        }
        public String getValue() {
            return chars[index % chars.length] + (index / chars.length);
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }
    private class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
        public EntrySet() {
            for (int i = 0; i < size; i++)
                add(new Entry(i));
        }
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<>() {
                final Entry entry = new Entry(-1);
                public boolean hasNext() {
                    return entry.index < size-1;
                }
                public Map.Entry<Integer, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }
        public int size() {
            return size;
        }
    }
    public Set<Map.Entry<Integer,String>> entrySet() {
        return entries;
    }
    Set<Map.Entry<Integer,String>> entries = new EntrySet();
    public static void main(String[] args) {
        System.out.println(new CountingMapData(80));
    }
}
