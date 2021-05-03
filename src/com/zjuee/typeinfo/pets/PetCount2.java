package com.zjuee.typeinfo.pets;

import java.util.Arrays;

public class PetCount2 {
    public static void main(String[] args) {
        System.out.println(Pets.arrayList(10));
        PetCount.countPets(Pets.creator);
        System.out.println(Arrays.toString(Pets.createArray(10)));
    }
}
