package com.zjuee.typeinfo.pets;

import com.zjuee.typeinfo.factory.Factory;

import java.util.*;

public class FactoryPetCreator {
    static List<Factory<? extends Pet>> petFactories = new ArrayList<>();
    static {
        petFactories.add(new Cymric.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Pug.Factory());
    }
    private static Random rand = new Random(47);
    public Pet randomPet() {
        int n = rand.nextInt(petFactories.size());
        return petFactories.get(n).creat();
    }
}
