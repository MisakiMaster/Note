package com.note.thead;

/**
 * @author master
 * @title: Communicate
 * @projectName Note
 * @description: 线程A,B交互通信
 * @date 2021/8/5 14:42
 */
public class Communicate implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 21; i++) {
            synchronized (this){
                /* 唤醒线程 */
                notify();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + count++);
                try {
                    /* 线程等待 */
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class CommunicateTest {
    public static void main(String[] args) {
        Communicate communicate = new Communicate();
        Thread thread1 = new Thread(communicate);
        Thread thread2 = new Thread(communicate);
        thread1.setName("线程A");
        thread2.setName("线程B");
        thread1.start();
        thread2.start();
    }
}