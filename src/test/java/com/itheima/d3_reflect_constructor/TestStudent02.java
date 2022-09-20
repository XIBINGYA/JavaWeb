package com.itheima.d3_reflect_constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestStudent02 {
    @Test
    public void getDeclaredFields() throws Exception {
        // a.定位class类对象
        Class c = Student.class;

        // b.定位全部成员变量
        Field[] fields = c.getDeclaredFields();

        // 遍历
        for (Field field : fields) {
            System.out.println(field.getName() + "==>" + field.getType());

        }
    }
    @Test
    public void getDeclaredField() throws Exception {
        // a.定位class类对象
        Class c = Student.class;

        // b.根据名称定位某个成员变量
        Field fAge = c.getDeclaredField("age");
        // 暴力破解
        fAge.setAccessible(true);
        // c.赋值
        Student s = new Student();
        fAge.set(s, 19); // s.setAge();
        System.out.println(s);

        // d.取值
        int age = (int)fAge.get(s); //s.getAge();
        System.out.println(age);
    }
}
