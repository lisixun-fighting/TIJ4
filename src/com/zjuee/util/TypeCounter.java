package com.zjuee.util;

import com.zjuee.typeinfo.pets.Pet;

import java.util.*;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }
    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: " + type +
                    ", should be type or subtype of " + baseType);
        }
        countClass(type);
    }
    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity+1);
        Class<?> superclass = type.getSuperclass();
        if(superclass != null && baseType.isAssignableFrom(superclass))
            countClass(superclass);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            res.append(pair.getKey().getSimpleName());
            res.append(" = ");
            res.append(pair.getValue());
            res.append(", ");
        }
        res.delete(res.length()-2, res.length());
        res.append("}");
        return res.toString();
    }
}
