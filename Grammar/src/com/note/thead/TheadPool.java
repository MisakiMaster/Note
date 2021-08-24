package com.note.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author master
 * @title: TheadPool
 * @projectName Note
 * @description: 线程池
 * @date 2021/8/5 14:54
 */


/*
    execute()执行任务,无返回值
    submit()提交任务,有返回值
 */

public class TheadPool {
    /* 单线程 */
    public void method1(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        service.shutdown();
    }
    /* 固定线程 */
    public void method2(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        service.shutdown();
    }
}
class TheadPoolTest{
    public static void main(String[] args) {
        new TheadPool().method1();
        System.out.println("----------------------------");
        new TheadPool().method2();
    }
}
