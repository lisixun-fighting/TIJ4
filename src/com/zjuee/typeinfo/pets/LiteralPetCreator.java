package com.zjuee.typeinfo.pets;

import java.util.*;

public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> allTypes =
            List.of(Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Mouse.class);
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return allTypes;
    }
    public static void main(String[] args) {
        System.out.println(types);
    }
}
