/**   
 * Filename:    Reflect.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 上午10:10:26   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.method_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射获取 普通的方法
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        Class<UtillClass> clazz = UtillClass.class;// 因为已经是是UtillClass的泛型,
                                                   // 不知道泛型的情况,可以直接用 Class

        System.out.println("*********获取所有的public方法(包括父类中的方法)***************");
        Method[] methodsPub = clazz.getMethods();// 1.获取所有的"共有方法",包括从父类中继承的共有方法.(想一下连Object中的共有方法都获取到了,所以是不管是有几次继承,会把所有的方法都获取到)
        for (Method m : methodsPub) {
            System.out.println(m.getName());
        }
        System.out.println("*********根据方法名和参数类型某个public方法***************");
        try {
            Method method = clazz.getMethod("showSuperClass2");// 父类中的方法.
            Method method2 = clazz.getMethod("showMessagePublic");// 父类中的方法.

            System.out.println(method.getName());
            System.out.println(method2.getName());
        } catch (SecurityException e1) {
            e1.printStackTrace();
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        }

        System.out.println("*********获取所有声明的方法***************");
        Method[] methodsDec = clazz.getDeclaredMethods();// 2.获取该字节码对应类中所有"声明的方法".(不管什么权限的方法都能获取)
        for (Method mm : methodsDec) {
            System.out.println(mm.getName());
        }

        System.out.println("*********根据方法名和参数类型来获取-声明的某个方法-*********");
        try {
            Method declaredMethod = clazz
                    .getDeclaredMethod("showMessagePrivate");// 根据方法名和参数类型来获取声明的某个方法.无参函数无参数类型
            Method declaredMethod2 = clazz.getDeclaredMethod(
                    "showMessagePrivate2", String.class, int.class);

            /* 调用方法: private 方法要先打开权限,然后调用invoke */
            declaredMethod2.setAccessible(true);
            try {

                System.out.println("反射调用invoke方法开始!");
                declaredMethod2.invoke(new UtillClass(), "Yves", 22);// 第一个参数为:该方法所在类的实例对象，后面为满足条件的实参．
                                                                     // 这里由于UtillClass类的构造是共有的,所以就直接new了,
                                                                     // 如果构造方法也是私有的,那么复杂点先暴力反射构造方法newInstance拿到该类的反射出来的实例对象
                System.out.println("反射调用invoke方法结束!");

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            System.out.println(declaredMethod.getName());
            System.out.println(declaredMethod2.getName());

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
