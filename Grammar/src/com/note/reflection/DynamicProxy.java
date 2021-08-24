package com.note.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author master
 * @title: DynamicProxy
 * @projectName Note
 * @description: 动态代理
 * @date 2021/8/18 11:20
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal proxyInstance = (Animal)ProxyFactory.getProxyInstance(cat);
        System.out.println(proxyInstance.getSay());
        proxyInstance.eat("鱼");

    }
}

/**
 * 接口
 */
interface Animal {

    String getSay();

    void eat(String food);
}

/**
 * 被代理类
 */
class Cat implements Animal {

    @Override
    public String getSay() {
        return "喵喵喵~~";
    }

    @Override
    public void eat(String food) {
        System.out.println("我吃" + food);
    }
}

/**
 * 代理类
 */
class ProxyFactory {
    /** 返回代理类对象 */
    public static Object getProxyInstance(Object obj){
        MyInvocationHander hander = new MyInvocationHander();
        hander.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),hander);
    }
}


class MyInvocationHander implements InvocationHandler{
    private Object obj;
    public void bind(Object obj){
        this.obj = obj;
    }
    /**
     * 通过代理对象调用方法,自动调用invoke()
     * 将被代理类执行的方法功能声明在invoke()中
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(obj,objects);
    }
}