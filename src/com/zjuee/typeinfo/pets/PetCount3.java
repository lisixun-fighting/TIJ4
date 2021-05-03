package com.zjuee.typeinfo.pets;

import com.zjuee.util.MapData;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }
        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet())
                if(pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue()+1);
        }
        public String toString() {
            StringBuilder res = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                res.append(pair.getKey().getSimpleName());
                res.append(" = ");
                res.append(pair.getValue());
                res.append(", ");
            }
            res.delete(res.length()-2, res.length());
            res.append("}");
            return res.toString();
        }

        public static void main(String[] args) {
            PetCounter counter = new PetCounter();
            for (Pet pet : Pets.createArray(20)) {
                System.out.print(pet.getClass().getSimpleName() + " ");
                counter.count(pet);
            }
            System.out.println();
            System.out.println(counter);
        }
    }
}
