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
package cn.com.yves.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        Class clazz = UtillClass.class;

        Method[] methods = clazz.getDeclaredMethods();// 获取该类中所有声明的方法
        System.out.println("总共的方法:" + methods.length);
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        System.out.println("**********************");

        for (Method m : methods) {

            System.out.println(m.getName());

            try {
                m.invoke(new UtillClass(), null);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
