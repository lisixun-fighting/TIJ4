package com.zjuee.generics;

interface Factory1<T> {
    <F> T create(F f);
}

class Foo2<T> {
    private T x;
    public <F extends Factory1<T>,E> Foo2(F factory, E e) {  // 限制类型，只接受实现了Factory1的工厂类对象
        x = factory.create(e);
    }
}

class IntegerFactory implements Factory1<Integer> {
    @Override
    public <F> Integer create(F f) {
        return 0;
    }
}

class Widget {
    public static class Factory implements Factory1<Widget> {
        public <F> Widget create(F f) {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory(), "hehe");
        new Foo2<>(new Widget.Factory(), "haha");
    }
}