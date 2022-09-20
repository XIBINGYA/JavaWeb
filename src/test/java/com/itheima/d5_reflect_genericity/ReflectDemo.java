package com.itheima.d5_reflect_genericity;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo {
    @Test
    public void ReflectTest() throws Exception{
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());

        System.out.println(list1.getClass() == list2.getClass());

        System.out.println("-----------");
        list2.add(23);
        list2.add(21);
//        list2.add("黑马");
        Class l2 = list2.getClass();

        Method add =l2.getDeclaredMethod("add", Object.class);
        boolean rs = (boolean) add.invoke(list2, "黑马");
        System.out.println(rs);
        System.out.println(list2);
    }
}
