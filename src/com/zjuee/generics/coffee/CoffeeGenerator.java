package com.zjuee.generics.coffee;

import com.zjuee.util.Generator;
import com.zjuee.util.TypeCounter;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class<?>[] types = { Latte.class, Mocha.class, Cappuccino.class, Amerciano.class, Breve.class, };
    private static Random rand = new Random(47);
    // for iteration
    private int size = 0;
    public CoffeeGenerator() {};
    public CoffeeGenerator(int size) {this.size = size; }
    // implement Generator<T>
    public Coffee next() {
        try{
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        public boolean hasNext() {
            return count > 0;
        }
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();  // 内部类调用外部类方法
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        TypeCounter counter = new TypeCounter(Coffee.class);
        for (int i = 0; i < 20; i++) {
            Coffee c = gen.next();
            System.out.print(c + " ");
            counter.count(c);
        }
        System.out.println();
        System.out.println(counter);
    }

}
