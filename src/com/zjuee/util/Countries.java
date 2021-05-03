package com.zjuee.util;

import java.util.*;

public class Countries {
    public static final String[][] DATA = {
            {"CANADA", "Ottawa"}, {"UNITED STATES OF AMERICA", "Washington, D.C"},
            {"BRAZIL", "Brasilia"}, {"RUSSIA", "Moscow"},
            {"ITALY", "Rome"}, {"SPAIN", "Madrid"},
            {"CHINA", "Beijing"}, {"EGYPT", "Cairo"},
            {"JAPAN", "Tokyo"}, {"KOREA", "Seoul"},
            {"GERMANY", "Berlin"}, {"GREECE", "Athens"},
            {"FRANCE", "Paris"}, {"THE NETHERLANDS", "Amsterdam"}
    };

    // Use AbstractMap by implementing entrySet()
    private static class FlyweightMap extends AbstractMap<String,String> {
        // Use Entry by implementing getKey() getValue() setValue()
        private static class Entry implements Map.Entry<String,String> {
            int index;
            Entry(int index) { this.index = index; }
            public boolean equals(Object o) {
                if(o instanceof String)
                    return DATA[index][0].equals(o);
                return false;
            }
            public String getKey() { return DATA[index][0]; }
            public String getValue() { return DATA[index][1]; }
            public String setValue(String value) {
                throw new UnsupportedOperationException("Read Only!");
            }
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }
        // Use AbstractSet by implementing size() & iterator
        static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
            private int size;
            EntrySet(int size) {
                if(size < 0)
                    this.size = 0;
                else if(size > DATA.length) {
                    this.size = DATA.length;
                }else {
                    this.size = size;
                }
            }
            public int size() { return size; }
            private class Iter implements Iterator<Map.Entry<String,String>> {
                private Entry entry = new Entry(-1);
                public boolean hasNext() {
                    return entry.index < size - 1;
                }
                public Map.Entry<String,String> next() {
                    entry.index++;
                    return entry;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
            public Iterator<Map.Entry<String,String>> iterator() {
                return new Iter();
            }
        }
        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }
    }
    // Create a partial map of 'size' countries
    static Map<String,String> select(final int size) {
        return new FlyweightMap() {
            public Set<Map.Entry<String,String>> entrySet(int size) {
                return new EntrySet(size);
            }
        };
    }
    static Map<String,String> map = new FlyweightMap();
    public static Map<String,String> capitals() {
        return map;
    }
    public static Map<String,String> capitals(int size) {
        return select(size);
    }
    static List<String> names = new ArrayList<>(map.keySet());
    public static List<String> names() { return names; }
    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(capitals());
        System.out.println(names());
        System.out.println(new HashMap<>(capitals(3)));
        System.out.println(new LinkedHashMap<>(capitals(3)));
        System.out.println(new TreeMap<>(capitals(3)));
        System.out.println(new LinkedHashSet<String>(names(3)));
        System.out.println(new HashSet<String>(names(3)));
        System.out.println(new LinkedList<String>(names(3)));
        System.out.println(new ArrayList<String>(names(3)));
        System.out.println(capitals().get("CHINA"));
    }
}
