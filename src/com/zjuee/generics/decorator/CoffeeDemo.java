package com.zjuee.generics.decorator;

enum Flavouring {
    MILK, FOAM, CHOCOLATE, CARAMEL
        }

class Coffee {
    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
}

class CoffeeDecorator extends Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    public void set(String val) {
        coffee.set(val);
    }
    public String get() {
        return coffee.get();
    }
    public void append(Flavouring f) {
        set(get() + " " + f.name());
    }
}

public class CoffeeDemo {
    public static void main(String[] args) {
        CoffeeDecorator coffee = new CoffeeDecorator(new Coffee());
        coffee.set("Latte");
        System.out.println(coffee.get());
        coffee.append(Flavouring.MILK);
        System.out.println(coffee.get());
        coffee.append(Flavouring.FOAM);
        System.out.println(coffee.get());
    }
}
