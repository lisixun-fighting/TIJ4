package com.zjuee.typeinfo.pets;

import com.zjuee.util.TypeCounter;

public class PetCount5 {
    public static void main(String[] args) {
        FactoryPetCreator creator = new FactoryPetCreator();
        TypeCounter counter = new TypeCounter(Pet.class);
        for (int i = 0; i < 20; i++) {
            Pet pet = Pets.randomPet(creator);
            System.out.print(pet + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
