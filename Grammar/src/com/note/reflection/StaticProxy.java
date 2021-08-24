package com.note.reflection;

/**
 * @author master
 * @title: StaticProxy
 * @projectName Note
 * @description: 静态代理, 代理类和被代理类在编译期间就确定下来
 * @date 2021/8/18 11:04
 */
public class StaticProxy {
    public static void main(String[] args) {
        Shoes shoes = new Shoes();
        ProxyShoesFactory shoesFactory = new ProxyShoesFactory(shoes);
        shoesFactory.produce();
    }
}

/**
 * 生产接口
 */
interface ShoesFactory {
    /**
     * 生产
     */
    void produce();
}

/**
 * 被代理类
 */
class Shoes implements ShoesFactory {
    @Override
    public void produce() {
        System.out.println("生产鞋子...");
    }
}

/**
 * 代理类
 */
class ProxyShoesFactory implements ShoesFactory {
    private ShoesFactory factory;

    public ProxyShoesFactory(ShoesFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produce() {
        System.out.println("代理工厂的准备工作...");
        factory.produce();
        System.out.println("代理工厂的收尾工作...");
    }
}