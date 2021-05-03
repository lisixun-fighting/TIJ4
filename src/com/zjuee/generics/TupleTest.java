package com.zjuee.generics;

import com.zjuee.util.*;

class Amphibian {}
class Vehicle {}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
}

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    static SixTuple<Vehicle, Amphibian, String, Integer, Double, Character> l() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1, 'a');
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> tti = f();
//        tti.first = 1; //final类型保护TwoTuple类的成员变量
        System.out.println(f());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(l());
    }
}
