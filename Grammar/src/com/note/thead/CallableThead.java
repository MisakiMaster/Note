package com.note.thead;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author master
 * @title: CallableThead
 * @projectName Note
 * @description: 实现Callable接口的线程方式 | 优点:可抛异常,有返回值
 * @date 2021/8/5 13:55
 */
public class CallableThead implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += i;
        }
        return sum;
    }
}
/*
    1.创建Callable子类对象
    2.创建FutureTask对象,构造方法传入Callable子类对象
    3.实例化Thead类,构造方法传入FutureTask对象
    4.调用start()
    5.FutureTask对象.get()获取返回值
 */

class CallableTheadTest{
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallableThead());
        Thread thread = new Thread(futureTask);
        thread.setName("thead");
        thread.start();
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}