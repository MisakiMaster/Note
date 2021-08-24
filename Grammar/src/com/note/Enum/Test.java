package com.note.Enum;

/**
 * @author master
 * @title: Test
 * @projectName Note
 * @description: TODO
 * @date 2021/8/9 16:39
 */
public class Test {
    public static void main(String[] args) {
        Sex male = Sex.MALE;
        //toString()
        System.out.println(male.toString());
        System.out.println("---------------------------------------------------------------------------");
        //values()
        Sex[] values = Sex.values();
        for (Sex sex : values) {
            System.out.println(sex);
        }
        System.out.println("---------------------------------------------------------------------------");
        //valueOf(String name) 返回枚举类对象名是name的对象,没有则抛异常
        Sex value = Sex.valueOf("MALE");
        System.out.println(value);
    }
}
