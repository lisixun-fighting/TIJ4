package com.zjuee.generics;

import com.zjuee.util.Tuple;
import com.zjuee.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object, Class<?>>...pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                delegatesByMethod.put(methodName, pair.first);
            }
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object proxied = delegatesByMethod.get(methodName);
        return method.invoke(proxied, args);
    }
    public static Object newInstance(TwoTuple...pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].getClass().getClassLoader();
        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                Tuple.tuple(new BasicImp(), Basic.class),
                Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
                Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class),
                Tuple.tuple(new ColoredImp(), IColored.class)
        );
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        IColored c = (IColored) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        System.out.println(c.color());
    }
}
