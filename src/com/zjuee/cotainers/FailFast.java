package com.zjuee.cotainers;

import java.util.*;

public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try{
            String s = it.next();
        }catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
