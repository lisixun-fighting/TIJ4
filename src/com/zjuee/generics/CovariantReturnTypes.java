package com.zjuee.generics;

class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived derived = d.get();
    }
}
