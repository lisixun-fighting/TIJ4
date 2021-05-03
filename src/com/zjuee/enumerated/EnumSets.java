package com.zjuee.enumerated;

import java.util.*;
import static com.zjuee.enumerated.AlarmPoints.*;

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        System.out.println(points);
        points.add(OFFICE1);
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);
        points.removeAll(EnumSet.of(OFFICE1, OFFICE2, OFFICE3, OFFICE4));
        System.out.println(points);
        EnumSet.complementOf(points);
        System.out.println(points);
    }
}
