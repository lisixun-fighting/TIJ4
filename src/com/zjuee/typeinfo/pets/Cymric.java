package com.zjuee.typeinfo.pets;

public class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }

    public static class Factory implements com.zjuee.typeinfo.factory.Factory<Cymric> {
        @Override
        public Cymric creat() {
            return new Cymric();
        }
    }
}
