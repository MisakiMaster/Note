package com.note.thead;

import static java.lang.Thread.sleep;

/**
 * @author master
 * @title: MyRunnable
 * @projectName Note
 * @description: 实现runnable接口的线程方式
 * @date 2021/8/5 13:14
 */
public class RunnableThead implements Runnable{

    private static int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            show();
        }
    }
    /* synchronized 同步锁 */
    public static synchronized void show() {
        if (count > 0) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + count--);
        }
    }
}

/*
    1.创建Runnable子类对象
    2.实例化Thead类,构造方法传入Runnable子类对象
    3.调用start()方法
 */
class RunnableTheadTest {
    public static void main(String[] args) {
        RunnableThead runnableThead = new RunnableThead();
        Thread thread = new Thread(runnableThead);
        thread.setName("myThead");
        thread.start();
    }
}
