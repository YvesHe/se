/**   
 * Filename:    Test2.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-1 上午11:12:53   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-1 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.method_;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Method类中常用方法API(可以看源码和API来理解)
 * 
 * @author Yves He
 * 
 */
public class Test2 {

    public static void main(String[] args) {
        Class<UtillClass> clazz = UtillClass.class;

        try {

            Method methodPri = clazz.getDeclaredMethod("showMessagePrivate2",
                    String.class, int.class);// 获取一个声明的private方法
            Method methodPub = clazz.getDeclaredMethod("showMessagePublic");// 获取一个声明的private方法

            methodPri.setAccessible(true);// 设置该方法跳过虚拟机对权限的检查,可以实现暴力反射

            System.out.println(methodPri.isAccessible());// 默认isAccessible不敢试public方法还是private方法都是为false,也就是不跳过java虚拟机的检查
            System.out.println(methodPub.isAccessible());

            System.out.println("***获取该方法的参数类型***");
            Class<?>[] parameterTypes = methodPri.getParameterTypes();
            for (Class c : parameterTypes) {
                System.out.println(c.getName());
            }

            System.out.println("***获取该方法的返回值类型***");
            Class<?> returnType = methodPri.getReturnType();
            System.out.println(returnType.getName());

            System.out.println("***获取该方法的所有异异常类型(没有就为长度为0的数组)***");
            Class<?>[] exceptionTypes = methodPri.getExceptionTypes();
            for (Class c : exceptionTypes) {
                System.out.println(c.getName());
            }

            System.out
                    .println("***获取该方法的 Java 语言修饰符(比如private对应int值,这些属性在Modifier中有定义)***");
            System.out.println(Modifier.PRIVATE);
            int modifiers = methodPri.getModifiers();// private方法的修饰符的值=Modifier.PRIVATE
            System.out.println(modifiers);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
