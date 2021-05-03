package com.zjuee.holding;

import java.util.*;

class Gerbil {
     int gerbilNumber;
     static int counter = 0;
     public Gerbil() {
        gerbilNumber = counter++;
     }
     public void hop() {
         System.out.println("Gerbil#" + gerbilNumber + " is hopping.");
     }
}

public class GerbilWithGenerics {
    public static void main(String[] args) {
        List<Gerbil> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Gerbil());
        }
        Iterator<Gerbil> it = list.iterator();
        while (it.hasNext()) {
            it.next().hop();
        }
    }
}
