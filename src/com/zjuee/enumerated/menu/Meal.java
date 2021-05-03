package com.zjuee.enumerated.menu;

public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.selectRandom();
                System.out.println(food);
            }
            System.out.println("-----");
        }
    }
}
