package com.zjuee.typeinfo;

import static net.mindview.util.Print.print;

interface Interface {
    void doSomething();
    void doSomethingElse(String arg);
}

class RealObjects implements Interface {
    @Override
    public void doSomething() {
        print("doSomething");
    }
    @Override
    public void doSomethingElse(String arg) {
        print("doSomethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    private int count = 0;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        proxied.doSomething();
        count++;
    }
    public void doSomethingElse(String arg) {
        proxied.doSomethingElse(arg);
        count++;
    }
    public int getCount() {
        return count;
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObjects());
        SimpleProxy proxy = new SimpleProxy(new RealObjects());
        consumer(proxy);
        consumer(proxy);
        consumer(proxy);
        System.out.println(proxy.getCount());
    }
}
