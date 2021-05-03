package com.zjuee.enumerated.menu;

import com.zjuee.enumerated.Enums;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    DESSERT(Food.Dessert.class),
    MAINCOURSE(Food.MainCourse.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food selectRandom() {
        return Enums.random(values);
    }
}
