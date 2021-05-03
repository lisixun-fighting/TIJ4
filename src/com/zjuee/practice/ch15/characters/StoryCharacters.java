package com.zjuee.practice.ch15.characters;

public class StoryCharacters {
    static int count = 0;
    final int id;
    public StoryCharacters() {
        id = count++;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + count;
    }
}
