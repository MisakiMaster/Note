package com.note.Enum;

/**
 * @author master
 * @title: Season
 * @projectName Note
 * @description: jdk5.0之前, 自定义枚举类Season
 * @date 2021/8/9 16:00
 */
public class Season {
    //声明属性需要用private final 来修饰
    private final String name;
    private final String desc;
    //私有化构造器,并赋值
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    //提供枚举对象
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
