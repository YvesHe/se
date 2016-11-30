/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午5:28:39   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        /* 两个跟注解相关的接口 */
        Annotation a = null;
        AnnotatedElement ae = null;// 接口是所有程序元素（例如java.lang.Class、java.lang.reflect.Method、java.lang.reflect.Constructor等）的父接口。

        // UseAnnotationClass bean = new UseAnnotationClass();
        // Class<? extends UseAnnotationClass> clazz = bean.getClass();

        Class clazz;
        try {
            clazz = Class.forName("cn.com.yves.annotation.UseAnnotationClass");

            /* 有了字节码,通过反射获取想要的部分 */
            Method[] methods = clazz.getMethods();
            System.out.println(methods.length);
            for (Method m : methods) {
                System.out.println(m.getName());
                boolean isAnMethod = m
                        .isAnnotationPresent(YvesAnnotation.class);// 这里是传入了要匹配的注解的字节码
                if (isAnMethod) {
                    System.out.println("***" + m.getName() + "***");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
