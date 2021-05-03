package com.zjuee.typeinfo.pets;

public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    public static class Factory implements com.zjuee.typeinfo.factory.Factory<Mouse> {
        @Override
        public Mouse creat() {
            return new Mouse();
        }
    }
}
