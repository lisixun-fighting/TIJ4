package com.zjuee.util;

public class TwoTuple<A,B> implements Comparable<TwoTuple<? super A, ? super B>> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return "(" + first + ", " + second + ")";
    }

    public boolean equals(Object o) {
        return o instanceof TwoTuple
                && o.hashCode() == hashCode();
    }

    public int hashCode() {
        return first.hashCode() * 37 + second.hashCode();
    }

    @Override
    public int compareTo(TwoTuple<? super A, ? super B> arg) {
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0) return firstCompare;
        if(arg.first != null) {
            int secondCompare = first.getClass().getSimpleName().compareTo(arg.first.getClass().getSimpleName());
            if(secondCompare != 0) return secondCompare;
        }
        return second.getClass().getSimpleName().compareTo(arg.second.getClass().getSimpleName());
    }
}
