package com.zjuee.arrays;

import java.util.*;

public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        System.out.println(Arrays.toString(la));
        ls = (List<String>[]) la;
//        ls = la;
        System.out.println(Arrays.toString(ls));
        ls[0] = new ArrayList<>();
        ls[1] = new LinkedList<>();
        ls[2] = new LinkedList<>();

        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

        List<BerylliumSphere>[] spheres = new List[10];
        for (int i = 0; i < 10; i++) {
            spheres[i] = new ArrayList<>();
        }
        System.out.println(spheres);

    }
}
