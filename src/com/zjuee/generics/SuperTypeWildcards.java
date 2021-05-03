package com.zjuee.generics;

import java.util.*;

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> list) {
        list.add(new Apple());
        list.add(new Jonathan());
    }
}
