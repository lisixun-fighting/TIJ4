package com.zjuee.generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private T[] array;
    private Class<?> type;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
        this.type = type;
    }
    public void put(int index, T t){
        array[index] = t;
    }
    public T get(int index) {
        return array[index];
    }
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        System.out.println(gai.rep().getClass().getSimpleName());
        Integer[] ia = gai.rep();
        System.out.println(gai.get(3));
        System.out.println(gai.get(2).getClass().getSimpleName());
    }
}
