package com.itheima.d3_reflect_constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestStudent01 {
    @Test
    public void getConstructors() throws Exception {
        // 获取类对象
        Class c = Student.class;
        // 提取类中全部的构造器对象
        Constructor cons = c.getDeclaredConstructor();

        // 如果遇到私有构造器，可以暴力反射，单次有效
        cons.setAccessible(true);
        Student stu = (Student) cons.newInstance();
        System.out.println(stu);

        // 定位某个有参构造器
        Constructor cons1 = c.getDeclaredConstructor(String.class,int.class);
//        (Student) Studen1 = (Student)cons1.newInstance("1", 2);
        System.out.println(cons1.getName()+"===>"+cons1.getParameterCount());
        Student s1 = (Student) cons1.newInstance("悟空",10000);
        System.out.println(s1);

    }
}
