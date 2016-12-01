/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午7:50:56   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.暴力反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 暴力反射:原理主要是对那些没有访问权限的构造方法,没有权限的方法,字段进行访问(比如在类声明类外访问该类的private的成员)
 * 
 * 主要操作:跳过java JVM 的权限检查(也就是打开访问权限):EG: methodsetAccessible(true);
 * 
 * 本例子:1.先反射private的构造方法,创建出实例对象,2.再反射出private方法,然后调用该方法.
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        /* 1.先暴力反射出构造方法,创建出实例 */
        Class<UtillClass> clazz = UtillClass.class;
        Constructor<UtillClass> constructorDec = null;
        UtillClass uc = null;

        try {
            constructorDec = clazz.getDeclaredConstructor(String.class,
                    int.class);// 按参数类型 获取声明的构造方法对象.
            constructorDec.setAccessible(true);// 打开构造访问的权限;跳过虚拟机的检查

            uc = constructorDec.newInstance("yvse", 22);// 产生实例:
                                                        // 参数按照构造方法中的参数类型填写即可.

            /* 产生对象后就可以正常方法改类中的能访问的信息了 */
            uc.show();

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /* 暴力反射UtillClass中的private方法 */
        System.out.println("************************");
        Method methodPri = null;
        try {
            methodPri = clazz.getDeclaredMethod("showMessage", String.class,
                    int.class);
            methodPri.setAccessible(true);// 跳过虚拟机对该方法的检查

            methodPri.invoke(uc, "YvesPri", 22); // 反射调用方法:第一个参数是该方法所在类的"实例对象",
                                                 // 也就是说该对象一定要实例化这里用的是上面已经通过反射得到的实例对象.
                                                 // 后面的参数是实参数列表
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /* 暴力反射UtillClass中private字段 */
        System.out.println("************************");
        try {
            Field declaredField = clazz.getDeclaredField("namePrivate");// 按字段名获取类中定义的字段
            declaredField.setAccessible(true);// 跳过虚拟机对该方法的检查

            int namePrivate = declaredField.getInt(uc);
            System.out.println(namePrivate);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}