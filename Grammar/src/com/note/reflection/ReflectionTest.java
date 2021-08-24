package com.note.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author master
 * @title: ReflectionTest
 * @projectName Note
 * @description: 反射
 * @date 2021/8/17 20:40
 */
public class ReflectionTest {
    /**
     * 　　* @description: 获取Class实例对象
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws ClassNotFoundException
     * 　　* @author master
     * 　　* @date 2021/8/17 22:20
     */
    @Test
    public void method1() throws ClassNotFoundException {
        //方式一:调用运行时类属性class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //方式二:调用运行时类对象getClass()
        Person p = new Person("Tom", "female", 18);
        Class<? extends Person> pClass = p.getClass();
        System.out.println(pClass);
        //方式三:调用Class类的静态方法forName(String classPath)
        Class<?> aClass = Class.forName("com.note.reflection.Person");
        System.out.println(aClass);
        //方式四:使用类加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("com.note.reflection.Person");
        System.out.println(loadClass);
    }

    /**
     * 　　* @description: 类加载器
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/17 23:14
     */
    @Test
    public void method2() {
        //自定义类使用系统类加载器进行加载
        ClassLoader loader = ReflectionTest.class.getClassLoader();
        System.out.println(loader);
        //调用系统类加载器getParent()获取扩展类加载器
        loader = loader.getParent();
        System.out.println(loader);
        //调用扩展类加载器getParent()无法获取引导类加载器
        //引导类加载器主要负责加载Java核心类库,无法加载自定义类
        loader = loader.getParent();
        System.out.println(loader);
    }

    /**
     * 　　* @description: 反射
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/17 20:52
     */
    @Test
    public void medthod3() throws Exception {
        //获取类
        Class<Person> personClass = Person.class;
        //利用反射创建Person类对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, int.class);
        Person person = constructor.newInstance("Tom", "female", 18);
        System.out.println(person);
        System.out.println("-----------------------------------------------------------------------------------");
        //获取类所在的包
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
        System.out.println("-----------------------------------------------------------------------------------");
        //获取类声明的注解
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        //获取类的父类
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
        System.out.println("-----------------------------------------------------------------------------------");
        //获取类的带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
        System.out.println("-----------------------------------------------------------------------------------");
        //获取类实现的接口
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        //通过反射调用对象属性方法(包括私有)
        /* 获取类所有构造器 */
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        /* 获取类所有属性 */
        Field[] fields = personClass.getDeclaredFields();
        for (Field f : fields) {
            //获取权限修饰符
            String permissions = Modifier.toString(f.getModifiers());
            //获取类型
            Class<?> type = f.getType();
            //获取变量名
            String name = f.getName();
            System.out.println(permissions + "\t" + type + "\t" + name);

        }
        System.out.println("-----------------------------------------------------------------------------------");
        /* 调用类指定属性 */
        Field age = personClass.getDeclaredField("age");
        /* 设置类属性可访问 */
        age.setAccessible(true);
        age.set(person, 10);
        System.out.println(person);
        System.out.println("-----------------------------------------------------------------------------------");
        /* 获取类所有方法 */
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            //获取方法注解
            annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //获取权限修饰符
            String permissions = Modifier.toString(method.getModifiers());
            //获取返回值类型
            String type = method.getReturnType().getName();
            //获取方法名
            String name = method.getName();
            //参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            String args = "" ;
            if (parameterTypes != null && parameterTypes.length != 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    args = parameterTypes[i].getName() + " args_" + i;
                    if (i != parameterTypes.length - 1) {
                        args += "," ;
                    }
                }
            }
            //抛出的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            String exception = "" ;
            if (exceptionTypes != null && exceptionTypes.length != 0) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    exception = "throws " + exceptionTypes[i].getName();
                    if (i != parameterTypes.length - 1) {
                        exception += "," ;
                    }
                }
            }
            System.out.println(permissions + "\t" + type + "\t" + name + "(" + args + ")" + "\t" + exception);
            System.out.println(method);
            System.out.println("-----------------------------------------------------------------------------------");
        }
        /* 调用类指定方法 */
        Method show = personClass.getDeclaredMethod("show");
        /* 设置类属性可访问 */
        show.setAccessible(true);
        Object str = show.invoke(person);
        System.out.println((String) str);
        System.out.println("-----------------------------------------------------------------------------------");


    }
}
