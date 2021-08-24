package com.note.thead;

/**
 * @author master
 * @title: HungrySingleton
 * @projectName Note
 * @description: 单例模式:饿汉式(线程安全)
 * @date 2021/8/5 13:39
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}



