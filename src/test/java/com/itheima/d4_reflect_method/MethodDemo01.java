package com.itheima.d4_reflect_method;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo01 {
    @Test
    public void getDeclareMethods() {
        // a.获取类对象
        Class c = Dog.class;

        // b.提取全部方法，包含是私有的
        Method[] methods = c.getDeclaredMethods();

        // c.遍历全部方法
        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.getReturnType() + " " + method.getParameterCount());
        }
    }

    @Test
    public void getDeclareMethod() throws Exception {
        // a.获取类对象
        Class c = Dog.class;

        // b.提取方法，包含是私有的
        Method method = c.getDeclaredMethod("eat");

        // 暴力打开权限
        method.setAccessible(true);

        Dog d = new Dog();

        Object invoke = method.invoke(d);
        System.out.println(invoke);

        Method method2 = c.getDeclaredMethod("eat", String.class);
        method2.setAccessible(true);

        Object ss = method2.invoke(d, "骨头");
        System.out.println(ss);
    }
}
