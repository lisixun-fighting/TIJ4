package com.zjuee.arrays;

import com.zjuee.util.Generator;

public class GeneratorTest {
    public static int size = 10;
    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()){
            System.out.print(type.getSimpleName() + ": ");
            try{
                Generator<?> g = (Generator<?>) type.getDeclaredConstructor().newInstance();
                for (int i = 0; i < size; i++)
                    System.out.print(g.next() + " ");
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Strategy Method
     * @param args
     */
    public static void main(String[] args) {
        test(RandomGenerator.class);
        test(CountingGenerator.class);
    }
}
