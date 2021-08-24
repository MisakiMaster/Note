package com.note.compare;

/**
 * @author master
 * @title: Person
 * @projectName Note
 * @description: TODO
 * @date 2021/8/8 13:14
 */
public class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
             Person p = (Person)o;
            if (this.age <= p.age) {
                if(this.age < p.age){
                    return -1;
                }else {
                    return this.name.compareTo(p.name);
                }
            } else {
                return  1;
            }
        }
        throw new RuntimeException("类型不一致!");
    }
}
