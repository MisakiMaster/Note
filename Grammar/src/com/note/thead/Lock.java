package com.note.thead;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author master
 * @title: Lock
 * @projectName Note
 * @description: 锁同步, 手动加锁, 释放锁
 * @date 2021/8/5 14:26
 */
public class Lock implements Runnable {
    private int count = 100;
    //true 公平锁 | false 不公平锁
    public ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(count--);
                } else {
                    break;
                }
                /* 释放资源 */
            } finally {
                /*  */
                lock.unlock();
            }
        }
    }
}
class LockTest{
    public static void main(String[] args) {
        Thread thread = new Thread(new Lock());
        thread.start();
    }
}