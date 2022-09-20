package com.itheima.d7_reflect_framework;

import org.junit.Test;

/**
 * 提供一个通用对象，支持保持所有对象的具体信息
 */
public class ReflectDemo {
    @Test
    public void demo(){
        Student s = new Student();
        s.setName("八戒");
        s.setClassName("西天跑率");
        s.setAge(1888);
        s.setSex('男');
        MybatisUtil.save(s);

        Teacher t = new Teacher();
        t.setName("波仔");
        t.setSex('男');
        t.setSalary(60000);
        MybatisUtil.save(t);
    }
}
