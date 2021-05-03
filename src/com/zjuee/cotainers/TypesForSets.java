package com.zjuee.cotainers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetType {
    int i;
    public SetType(int n) { this.i = n; }
    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType)o).i);
    }
    public String toString() { return Integer.toString(i); }
}

class HashType extends SetType {
    public HashType(int n) { super(n); }
    public int hashCode() { return i; }
}

// TreeType声明实现了Comparable接口，这样才能被TreeSet接受
class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int n) {
        super(n);
    }
    public int compareTo(TreeType arg) {
        return (Integer.compare(arg.i, i));
    }
}

public class TypesForSets {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try{
            for (int i = 0; i < 10; i++)
                set.add(type.getConstructor(int.class).newInstance(i));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }
    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(), HashType.class);
        test(new LinkedHashSet<>(), HashType.class);
        test(new TreeSet<>((TreeType o1, TreeType o2) -> Integer.compare(o1.i, o2.i)), TreeType.class);

        test(new HashSet<SetType>(), SetType.class);  // SetType没有实现hashCode，因此不仅无序，而且可重复
        test(new LinkedHashSet<SetType>(), SetType.class);
    }
}
