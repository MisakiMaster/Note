package com.note.thead;

/**
 * @author master
 * @title: LazySingleton
 * @projectName Note
 * @description: 单例模式:懒汉式(线程不安全)
 * @date 2021/8/5 13:45
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(instance == null){
            return new LazySingleton();
        }
        return instance;
    }

}
