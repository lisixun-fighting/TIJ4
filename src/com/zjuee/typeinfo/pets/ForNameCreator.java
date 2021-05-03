package com.zjuee.typeinfo.pets;

import java.util.*;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "com.zjuee.typeinfo.pets.Cat",
            "com.zjuee.typeinfo.pets.Dog",
            "com.zjuee.typeinfo.pets.Rodent",
            "com.zjuee.typeinfo.pets.Cymric",
            "com.zjuee.typeinfo.pets.EgyptianMau",
            "com.zjuee.typeinfo.pets.Manx",
            "com.zjuee.typeinfo.pets.Mouse",
            "com.zjuee.typeinfo.pets.Rodent"
    };
    private static void loader() {
        try {
            for (String typeName : typeNames)
                types.add((Class<? extends Pet>)Class.forName(typeName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static {
        loader();
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
