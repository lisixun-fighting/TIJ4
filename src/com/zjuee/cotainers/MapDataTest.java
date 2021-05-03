package com.zjuee.cotainers;

import com.zjuee.arrays.CountingGenerator;
import com.zjuee.arrays.RandomGenerator;
import com.zjuee.util.Generator;
import com.zjuee.util.MapData;
import com.zjuee.util.Pair;

import java.util.Iterator;
import java.util.Map;

class Letters implements Generator<Pair<Integer,String>>, Iterable<Integer> {
    private final int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            public boolean hasNext() {
                return number < size;
            }
            public Integer next() {
                return number++;
            }
        };
    }
    public Pair<Integer, String> next() {
        return new Pair<>(number++, ""+letter++);
    }
}


public class MapDataTest {
    public static void main(String[] args) {
        // <Integer,String>
        System.out.println(new MapData<>(new Letters(), 11));
        // <Pair<>, Float>
        System.out.println(MapData.map(new Letters(), new RandomGenerator.Float(), 8));
        // <Integer, Float>
        System.out.println(MapData.map(new Letters(), new RandomGenerator.Float()));
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
    }
}
