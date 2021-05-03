package com.zjuee.arrays;

class ClassParameter<T> {
    public T[] f(T[] args) {
        return args;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] args) {
        return args;
    }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints); // 创建了同一个对象数组一个新的引用
        Double[] doubles2 = MethodParameter.f(doubles);
        System.out.println(ints);
        System.out.println(ints2);
    }
}
