package com.note.newFeatures;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author master
 * @title: LambdaTest
 * @projectName Note
 * @description: Java新特性
 * @date 2021/8/18 15:04
 */
public class LambdaTest {
    /**
     * 　　* @description: lambda表达式: (参数列表) -> {}  / 方法引用
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/18 15:28
     */
    @Test
    public void method1() {
        //正常代码
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(t1, t2);
            }
        };
        int res = comparator.compare(21, 36);
        System.out.println(res);
        System.out.println("--------------------------------------------------------");
        //使用lambda表达式
        comparator = (t1, t2) -> Integer.compare(t1, t2);
        res = comparator.compare(21, 36);
        System.out.println(res);
        System.out.println("--------------------------------------------------------");
        //使用方法引用
        comparator = Integer::compare;
        res = comparator.compare(21, 36);
        System.out.println(res);
    }

}
