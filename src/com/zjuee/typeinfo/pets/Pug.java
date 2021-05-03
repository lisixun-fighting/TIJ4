package com.zjuee.typeinfo.pets;

public class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }

    public static class Factory implements com.zjuee.typeinfo.factory.Factory<Pug> {
        @Override
        public Pug creat() {
            return new Pug();
        }
    }
}
