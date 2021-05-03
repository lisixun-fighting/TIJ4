package com.zjuee.typeinfo.pets;

import java.util.*;

public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();
    public static Pet randomPet(FactoryPetCreator creator) {
        return creator.randomPet();
    }
    public static Pet randomPet() {
        return creator.randomPet();
    }
    public static Pet[] createArray(int size) {
        Pet[] res = new Pet[size];
        for (int i = 0; i < size; i++)
            res[i] = randomPet();
        return res;
    }
    public static List<Pet> arrayList(int size) {
        ArrayList<Pet> res = new ArrayList<>();
        Collections.addAll(res, createArray(size));
        return res;
    }
}
