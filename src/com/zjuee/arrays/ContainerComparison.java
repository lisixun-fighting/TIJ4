package com.zjuee.arrays;

import com.zjuee.util.Generated;

import java.util.*;

class BerylliumSphere {
    private static long counter;
    private long id = counter++;
    public String toString() {
        return "Sphere " + id;
    }
    public void setId(long id) {
        this.id = id;
    }
}

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliumSphere());
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = { 0, 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(integers));

        List<Integer> inList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
        inList.add(6);
        System.out.println(inList);

        BerylliumSphere[] blist = Generated.array(BerylliumSphere.class, BerylliumSphere::new, 10);

    }
}
