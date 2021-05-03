package com.zjuee.typeinfo.pets;

public class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }
    public Manx() {
        super();
    }
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<Manx> {
        @Override
        public Manx creat() {
            return new Manx();
        }
    }
}
