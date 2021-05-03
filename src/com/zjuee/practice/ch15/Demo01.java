package com.zjuee.practice.ch15;

public class Demo01 {
    static class Holder<T> {
        T obj1;
        T obj2;
        T obj3;

        public Holder(T...array) {
            obj1 = array[0];
            obj2 = array[1];
            obj3 = array[2];
        }

        public T getObj1() {
            return obj1;
        }

        public void setObj1(T obj1) {
            this.obj1 = obj1;
        }

        public T getObj2() {
            return obj2;
        }

        public void setObj2(T obj2) {
            this.obj2 = obj2;
        }

        public T getObj3() {
            return obj3;
        }

        public void setObj3(T obj3) {
            this.obj3 = obj3;
        }
    }

    public static void main(String[] args) {
        Holder<Integer> holder = new Holder<>(1,2,3);
        System.out.println(holder.getObj1());
        System.out.println(holder.getObj2());
        System.out.println(holder.getObj3());
    }
}
