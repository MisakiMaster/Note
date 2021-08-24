package com.note.Enum;

/**
 * @author master
 * @title: Season
 * @projectName Note
 * @description: jdk5.0使用enum关键字来自定义枚举类Sex
 * 定义的枚举类默认继承java.lang.Enum类
 * @date 2021/8/9 16:00
 */

public enum Sex {
    //提供枚举类对象,用','隔开,用';'结尾
    MALE("男"),
    FEMALE("女");
    private final String name;
    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

