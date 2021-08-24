package com.note.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author master
 * @title: CollectionTest
 * @projectName Note
 * @description: 集合框架
 * Collection 接口: 单列集合,存储对象
 *   > List接口: 有序,可重复 -----> ArrayList, LinkedList, Vector
 *   > Set接口: 无序,不可重复 -----> HashSet, LinkedHashSet, TreeSet
 * Map 接口: 双列集合,存储键值对(key-->value)
 *   > HashMap, LinkedHashMap, TreeMap, Hashtable, properties
 * @date 2021/8/10 16:27
 */
public class CollectionTest {
    /**
    　　* @description: List接口
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/12 22:47
    　　*/
    @Test
    public void method1(){
        ArrayList<String> list = new ArrayList<>();
        //add() 增
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        //remove() 删
        list.remove("AAA");
        //set() 改
        list.set(0,"666");
        //get() 获取
        String s = list.get(1);
        System.out.println(s);
        //indexOf() 查
        int index = list.indexOf("CCC");
        System.out.println(list.get(index));
        //contains() 包含
        boolean contains = list.contains("BBB");
        System.out.println(contains);
        //toString()
        System.out.println(list);
        System.out.println("-----------------------------------------------------------------------------");

        //遍历方式1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------");
        //遍历方式2
        for (String n: list) {
            System.out.println(n);
        }
        System.out.println("-----------------------------------------------------------------------------");
        //遍历方式3
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    /**
    　　* @description: Map接口
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/13 23:35
    　　*/
    @Test
    public void method2(){
        HashMap<Integer, Character> map = new HashMap<>(16);
        String seed = "ABCDEFG";
        for (int i = 0; i < seed.length(); i++) {
            map.put(i,seed.charAt(i));
        }
        Set<Map.Entry<Integer, Character>> set = map.entrySet();
        for (Map.Entry<Integer, Character> next : set) {
            System.out.println(next.getKey() + "--->" + next.getValue());
        }

    }
    /**
    　　* @description: Collections工具类
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/13 23:36
    　　*/
    @Test
    public void method3(){
        List<Integer> list = Arrays.asList(2, 8, 6, 9, 4, 3, 7, 22, 11);
        System.out.println(list);
        //reverse() 反转
        Collections.reverse(list);
        System.out.println(list);
        //sort(compare) 排序
        Collections.sort(list);
        System.out.println(list);
        //shuffle() 打乱
        Collections.shuffle(list);
        System.out.println(list);
        //frequency(list,e) e在list出现次数
        int frequency = Collections.frequency(list, 0);
        System.out.println(frequency);
        //min() / max() 集合里最大(小)值,需要Compare的接口
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println(min + "---" + max);
        //copy() 复制
        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

    }

}
