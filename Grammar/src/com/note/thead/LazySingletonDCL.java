package com.note.thead;

/**
 * @author master
 * @title: LazySingletonDCL
 * @projectName Note
 * @description: 单例模式:懒汉式双重校验锁(线程安全)
 * @date 2021/8/5 13:50
 */
public class LazySingletonDCL {
    private static LazySingletonDCL instance;
    private LazySingletonDCL(){}
    public static LazySingletonDCL getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    return new LazySingletonDCL();
                }
            }
        }
        return instance;
    }
}
