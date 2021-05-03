package com.zjuee.generics;

import java.util.HashMap;
import java.util.Map;

class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> kindMap = new HashMap<>();
    private T t;
    public void addType(String typename, Class<?> kind) {
        kindMap.put(typename, kind);
    }
    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        Class<?> kind = kindMap.get(typename);
        return kind.newInstance();
    }
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

//        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        ctt1.addType("Building", Building.class);
        Building b =  (Building) ctt1.createNew("Building");
        System.out.println(b);

        ctt1.addType("House", House.class);
        House h = (House) ctt1.createNew("House");
        System.out.println(h);
    }
}
