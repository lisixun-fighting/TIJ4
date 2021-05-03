package com.zjuee.typeinfo.pets;

import java.util.*;

public abstract class PetCreator {
    private Random rand = new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet() {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public Pet[] createArray(int size) {
        Pet[] res = new Pet[size];
        for (int i = 0; i < size; i++)
            res[i] = randomPet();
        return res;
    }
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> res = new ArrayList<>();
        Collections.addAll(res, createArray(size));
        return res;
    }
}
