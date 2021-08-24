package com.note.reflection;

/**
 * @author master
 * @title: Person
 * @projectName Note
 * @description: 用于测试反射
 * @date 2021/8/17 20:41
 */
public class Person implements Comparable{
    private String name;
    private String sex;
    private int age;

    private Person() {
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    private String show(){
        String str = "I am a people";
        System.out.println(str);
        return str;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
