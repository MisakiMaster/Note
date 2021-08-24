package com.note.newFeatures;

import org.junit.Test;

import java.util.Optional;

/**
 * @author master
 * @title: OptionalTest
 * @projectName Note
 * @description: Optional
 * > 是个容器类,保存T类型的值
 * > 可以避免空指针异常
 * @date 2021/8/19 11:26
 */
public class OptionalTest {
    /**
    　　* @description: 创建Optional实例
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/19 11:32
    　　*/
    @Test
    public void method1(){
        //创建实例 Optional.of(T value) value必须非null
        Optional<String> str = Optional.of("");
        System.out.println(str);
        //创建实例 Optional.ofNullable(T value) value可以为null
        str = Optional.ofNullable(null);
        System.out.println(str);
        //创建空例 Optional.empty()
        str = Optional.empty();
        System.out.println(str);
    }
    @Test
    public void method2(){
        Optional<String> str = Optional.ofNullable(null);
        System.out.println(str);
        //orElse(T t)
        //如果当前Optioanal内部非空,则返回内部t
        //如果当前Optioanal内部为空,则返回参数t
        String s = str.orElse("str");
        System.out.println(s);
    }

}
