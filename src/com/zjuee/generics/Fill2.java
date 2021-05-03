package com.zjuee.generics;

import com.zjuee.generics.coffee.Coffee;
import com.zjuee.generics.coffee.Latte;
import com.zjuee.generics.coffee.Mocha;
import com.zjuee.util.Generator;
import java.util.*;

interface Addable<T> {
    void add(T t);
}

public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++)
            try {
                addable.add(classToken.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
    public static <T> void fill(Addable<T> addable, Generator<T> gen, int size) {
        for (int i = 0; i < size; i++)
            addable.add(gen.next());
    }
}

/**
 * proxy + adapter
 * @param <T>
 */
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }
    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(
                new AddableCollectionAdapter<>(carrier),
                Coffee.class, 4);
        Fill2.fill(
                Adapter.collectionAdapter(carrier),
                Latte.class, 2);
        for (Coffee coffee : carrier)
            System.out.println(coffee);

        AddableSimpleQueue<Coffee> coffees = new AddableSimpleQueue<>();
        Fill2.fill(coffees, Mocha.class, 4);
        Fill2.fill(coffees, Latte.class, 1);
    }
}
