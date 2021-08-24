package com.note.newFeatures;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author master
 * @title: StreamTest
 * @projectName Note
 * @description: Stream
 * > Stream关注数据的运算,与CPU打交道
 * > Collection关注数据的存储,与内存打交道
 * > 特点
 *      > 不会存储元素
 *      > 不会改变源对象,返回持有结果新的stream
 *      > 操作延时执行,等到结果才执行
 * > 执行流程
 *      > 实例化
 *      > 中间操作
 *      > 终止操作
 * > 说明
 *      > 一个中间操作链,对数据源进行处理
 *      > 一旦执行终止操作,就执行中间操作链,并产生结果,并不再使用
 *
 * @date 2021/8/18 22:53
 */

public class StreamTest {
    /**
    　　* @description: 创建Stream的方式
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/18 22:59
    　　*/
    @Test
    public void method1(){
        //创建方式一: 通过集合
        List<Integer> list = Arrays.asList(4, 2, 9, 3, 8, 7, 0, 5);
        /* 返回顺序流 */
        Stream<Integer> stream = list.stream();
        /* 返回并行流 */
        Stream<Integer> parallelStream = list.parallelStream();
        //创建方式二: 通过数组
        int[] arr = {4, 2, 9, 3, 8, 7, 0, 5};
        IntStream intStream = Arrays.stream(arr);

        //创建方式三: 通过Stream.of()
        Stream<Integer> integerStream = Stream.of(4, 2, 9, 3, 8, 7, 0, 5);
        //创建方式四: 创建无限流
        /* iterate */
        Stream<Integer> iterate = Stream.iterate(0, t -> t + 2).limit(10);
        iterate = Stream.iterate(0,t -> t < 30, t -> t + 2);
        /* generate */
        Stream<Double> doubleStream = Stream.generate(Math::random).limit(10);
    }
    /**
    　　* @description: 筛选,切片,映射
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/18 23:12
    　　*/
    @Test
    public void method2(){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(10));
        }
        //创建流
        Stream<Integer> stream = list.stream();
        //排除 filter(Prdicate p) 接收lambda,排除元素
        stream.filter(v -> v > 5).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //截断 limit(n) 使元素不超过指定数量n
        stream = list.stream();
        stream.limit(5).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //跳过 skip(n) 跳过前n个元素,不足则为空
        stream = list.stream();
        stream.limit(5).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //筛选 distinct() 通过元素的hashCode()和equals()去除重复元素
        stream = list.stream();
        stream.distinct().forEach(System.out::println);
        //映射 map(Function f) 接收函数,函数会应用每个元素,将其映射成新的元素
        stream = list.stream();
        stream.map(v -> v + 5).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        // takeWhile(Prdicate p) 接收lambda,返回直到不满足条件元素之前的元素
        stream = list.stream();
        stream.takeWhile(v -> v > 5).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        // dropWhile(Prdicate p) 接收lambda,返回直到满足条件元素之前的元素
        stream = list.stream();
        stream.dropWhile(v -> v > 5).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //sorted() 自然排序
        stream = list.stream();
        stream.sorted().forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //sorted(Comparator comp) 自然排序
        stream = list.stream();
        stream.sorted((v1,v2) -> -Integer.compare(v1,v2)).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //allMatch(Prdicate p) 检查是否匹配所有元素
        stream = list.stream();
        boolean flag = stream.allMatch(v -> v > 5);
        System.out.println(flag);
        //anyMatch(Prdicate p) 检查是否至少匹配一个 元素
        stream = list.stream();
        flag = stream.anyMatch(v -> v < 2);
        System.out.println(flag);
        //noneMatch(Prdicate p) 检查是否没有匹配的元素
        stream = list.stream();
        flag = stream.noneMatch(v -> v == 2);
        System.out.println(flag);
        //findFirst() 返回第一个元素
        stream = list.stream();
        Optional<Integer> first = stream.findFirst();
        System.out.println(first);
        //findAny() 返回任意元素
        stream = list.parallelStream();
        Optional<Integer> any = stream.findAny();
        System.out.println(any);
        //count() 个数
        stream = list.stream();
        long count = stream.count();
        System.out.println(count);
        System.out.println("---------------------------------------------");
        //max(Prdicate p) 返回最大值
        stream = list.stream();
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println(max);
        //max(Prdicate p) 返回最大值
        stream = list.stream();
        Optional<Integer> min = stream.min(Integer::compare);
        System.out.println(min);
        //forEach(Consumer c) 内部迭代
        stream = list.stream();
        stream.forEach(System.out::println);
        // 归约
        //reduce(T identity,BinaryOperator)
        //将流中数据反复结合,得到一个值,返回T
        stream = list.stream();
        Integer sum = stream.reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce(BinaryOperator)
        //将流中数据反复结合,得到一个值,返回Operator<T>
        stream = list.stream();
        Optional<Integer> res = stream.reduce(Integer::sum);
        System.out.println(res);
        //collect(Collector c)
        stream = list.stream();
        List<Integer> collect = stream.filter(v -> v < 5).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
