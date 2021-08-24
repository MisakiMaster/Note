package com.note.thead;

/**
 * @author admin
 * @title: MyThead
 * @projectName Note
 * @description: 继承thead类的线程方式
 * @date 2021/8/5 12:59
 */
public class MyThead extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
            if(i == 10){
                yield();
            }
        }
    }
}
/*
    1.创建Thead子类对象
    2.调用start()方法
 */
class MytheadTest {
    public static void main(String[] args) {
        MyThead myThead = new MyThead();
        myThead.setName("myThead");
        myThead.start();
    }
}
