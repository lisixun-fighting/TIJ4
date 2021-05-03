package com.zjuee.practice.ch15.characters;

import com.zjuee.util.Generator;

import java.util.Iterator;
import java.util.Random;

public class CharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private Class<?>[] items = { GoodGuys.class, BadGuys.class, StoryCharacters.class };
    private Random rand = new Random(47);
    private int size;
    public CharactersGenerator(int size) {
        this.size = size;
    }
    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) items[rand.nextInt(items.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Iterator<StoryCharacters> iterator() {
        return new Iterator<StoryCharacters>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }
            @Override
            public StoryCharacters next() {
                size--;
                return CharactersGenerator.this.next();
            }
        };
    }

    public static void main(String[] args) {
        CharactersGenerator gen = new CharactersGenerator(10);
        for (StoryCharacters characters : gen) {
            System.out.println(characters);
        }
    }
}
