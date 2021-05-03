package com.zjuee.arrays;

import com.zjuee.util.Generated;

import java.util.Arrays;
import java.util.Comparator;

// 编写比较器实现类，按j生序排列
class CompTypeComparator implements Comparator<CompType> {
    public int compare(CompType o1, CompType o2) {
        return Integer.compare(o1.j, o2.j);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        System.out.println("before sorting");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        System.out.println("after sorting");
        System.out.println(Arrays.toString(a));
    }
}
