package com.zjuee.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    private int count = 0;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null) {
            args[0] = "balabala";
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        count++;
        return method.invoke(proxied, args);
    }
    public int getCount() {
        return count;
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObjects real = new RealObjects();
        DynamicProxyHandler dph = new DynamicProxyHandler(real);
//        consumer(real);
        Interface proxy = (Interface)Proxy.newProxyInstance(SimpleDynamicProxy.class.getClassLoader(),
                new Class[] {Interface.class},
                dph);
        consumer(proxy);
        consumer(proxy);
        consumer(proxy);
        System.out.println(dph.getCount());
    }
}
