package com.zjuee.generics;

import java.util.*;

import com.zjuee.typeinfo.Person;
import com.zjuee.typeinfo.pets.Pet;



public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {}
    static <K,V> Map<K,V> map() {
        return new HashMap<>();
    }
    public static void main(String[] args) {
        f(map());
    }
}
