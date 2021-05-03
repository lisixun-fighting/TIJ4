package com.zjuee.cotainers;

import com.zjuee.arrays.RandomGenerator;
import com.zjuee.util.CollectionData;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<>(CollectionData.list(
                new RandomGenerator.String(9), 10)));
        System.out.println(new HashSet<>(CollectionData.list(
                new RandomGenerator.Float(), 10)));
    }
}
