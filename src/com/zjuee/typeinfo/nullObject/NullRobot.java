package com.zjuee.typeinfo.nullObject;

import com.zjuee.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot(); // 声明代理对象proxied
    NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName() + " NullRobot";   // type为snowRemovalRobot
    }
    // 创建代理对象的类NRobot，实现接口Robot，Null
    private class NRobot implements Robot, Null {
        public String name() {return nullName;}
        public String model() {return nullName;}
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(proxied, args);
    }
}

public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),   // 传递一个类加载器
                new Class[]{Null.class, Robot.class}, // 代理实现的接口列表
                new NullRobotProxyHandler(type)     // 构造一个代理类对象
        );
    }
    public static void main(String[] args) {
        Robot[] robots = {
                new SnowRemovalRobot("Biden"),
                newNullRobot(SnowRemovalRobot.class)  // 空对象
        };
        for (Robot robot: robots) {
            Robot.Test.test(robot);
        }
    }
}
