package com.zjuee.typeinfo.pets;

public class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }
    public Mutt() {
        super();
    }
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<Mutt> {
        @Override
        public Mutt creat() {
            return new Mutt();
        }
    }
}
