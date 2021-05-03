package com.zjuee.typeinfo.pets;

public class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }
    public static class Factory implements com.zjuee.typeinfo.factory.Factory<EgyptianMau> {
        @Override
        public EgyptianMau creat() {
            return new EgyptianMau();
        }
    }
}
