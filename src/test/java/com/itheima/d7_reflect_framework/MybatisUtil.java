package com.itheima.d7_reflect_framework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {
    /**
     * 保持任意类型的对象
     *
     * @param obj
     */
    public static void save(Object obj) {
        try(
                PrintStream ps = new PrintStream(new FileOutputStream("src/test/java/com/itheima/d7_reflect_framework/data.txt", true));

        ) {

            // 1、提取这个对象的全部成员变量：只有反射可以解决
            Class c = obj.getClass();
            String simpleName = c.getSimpleName();
            ps.println("=========="+simpleName+"==========");

            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                // 提取本成员2
                field.setAccessible(true);
                String value = field.get(obj) + "";
                ps.println(name+"="+value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

