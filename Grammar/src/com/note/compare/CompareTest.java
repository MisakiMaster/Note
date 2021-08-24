package com.note.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author master
 * @title: CompareTest
 * @projectName Note
 * @description: Compare比较器: Comparable自然排序,Comparator定制排序
 * Java对象正常情况下只能比较 == 或 != ,不能使用 > 或 < ,
 * 如需要比较要实现Comparable 或 Comparator 接口
 * 重写CompareTo(obj)方法,指定排序方式
 * @date 2021/8/8 12:49
 */
public class CompareTest {
    /**
    　　* @description: String和包装类默认实现了Comparable接口,重写了compareTo()方法
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/8 13:02
    　　*/
    @Test
    public void method1() {
        String[] arr = new String[]{"MM", "DD", "GG", "JJ", "AA", "ZZ"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
    　　* @description: 自定义类比较
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/8 13:28
    　　*/
    @Test
    public void method2(){
        Random random = new Random();
        String seed = "ABCDE";
        Person[] arr = new Person[5];
        for (int i = 0; i < seed.length(); i++) {
            arr[i] = new Person("小" + seed.charAt(i),random.nextInt(100));
        }
        Arrays.sort(arr);
        for (Person p: arr) {
            System.out.println(p);
        }
    }
    /**
    　　* @description: 定制排序 从大到小
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/8 14:16
    　　*/
    @Test
    public void method3(){
        String[] arr = new String[]{"MM", "DD", "GG", "JJ", "AA", "ZZ"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return -s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
