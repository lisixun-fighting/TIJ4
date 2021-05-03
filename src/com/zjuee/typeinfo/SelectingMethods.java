package com.zjuee.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.mindview.util.Print.print;

class MethodSelector implements InvocationHandler {
    private Object proxied;
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting"))
            print("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethods {

    @Override
    public void boring1() {
        print("boring1");
    }

    @Override
    public void boring2() {
        print("boring2");
    }

    @Override
    public void interesting(String arg) {
        print("interesting " + arg);
    }

    @Override
    public void boring3() {
        print("boring3");
    }
}

public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxied = (SomeMethods) Proxy.newProxyInstance(SelectingMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxied.boring1();
        proxied.boring2();
        proxied.boring3();
        proxied.interesting("bonobo");
    }
}
