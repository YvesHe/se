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
package cn.com.yves.reflect.class_;

/**
 * 三种获取字节码的方式
 * 
 * @author Yves He
 * 
 */
public class Test {
    public static void main(String[] args) {

        // 方式一:
        Class<?> clazz1 = getClazz1();

        // 方式二:
        UserBean uBean = new UserBean();
        Class<?> clazz2 = getClazz2(uBean);

        // 方式三:
        Class<?> clazz3 = UserBean.class;

        // 通过字节码可以产生对象
        try {
            Object newInstance1 = clazz1.newInstance();
            Object newInstance2 = clazz2.newInstance();
            Object newInstance3 = clazz3.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /* 方式一: */
    public static Class<?> getClazz1() {
        Class clazz = null;
        try {
            clazz = Class.forName("cn.com.yves.reflect.class_.UserBean");// 注意类要存在,否则进异常
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /* 方式二 */
    public static Class<?> getClazz2(Object o) {
        return o.getClass();
    }

}
