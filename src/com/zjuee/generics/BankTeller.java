package com.zjuee.generics;

import com.zjuee.util.Generator;
import java.util.*;

class Customer {
    private static long counter = 1;
    private final long id = counter ++;
    private Customer() {}
    public String toString() {return "Customer-" + id; }
    // 创建Customer的静态方法generator，能够返回一个Generator<Customer>的实现类对象
    public static Generator<Customer> generator() {
        return Customer::new;
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter ++;
    private Teller() {}
    public String toString() {return "Teller-" + id; }
    // 创建Teller的静态对象generator，generator也是Generator<Teller>的实现类对象
    public static Generator<Teller> generator = Teller::new;
}


public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(4)), c);
        }
    }
}
