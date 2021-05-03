package com.zjuee.generics;

import com.zjuee.generics.coffee.Coffee;
import com.zjuee.generics.coffee.CoffeeGenerator;
import com.zjuee.util.Generator;

import java.util.*;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> Collection<T> fill(Collection<T> coll, Set<T> set) {
        coll.addAll(set);
        return coll;
    }

    public static <T> Collection<T> fill(Collection<T> coll, List<T> list) {
        coll.addAll(list);
        return coll;
    }

    public static <T> Collection<T> fill(Collection<T> coll, LinkedList<T> list) {
        coll.addAll(list);
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            System.out.println(c);

        System.out.println();
        fill(coffee, new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            System.out.println(c);

    }
}
