package com.zjuee.typeinfo;

class Building {}
class House extends Building {}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        House h = (House) b;
        Class<House> houseType = House.class;
        House h2 = houseType.cast(b);
        if(b instanceof House) {
            System.out.println("b is House");
        }
        if(h2 instanceof House) {
            System.out.println("h2 is House");
        }
    }
}
