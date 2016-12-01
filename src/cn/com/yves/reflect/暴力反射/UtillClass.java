/**   
 * Filename:    User.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午7:51:18   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.暴力反射;

/**
 * 这是一个等待被反射的类.
 * 
 * @author Yves He
 * 
 */
public class UtillClass {

    /* 都最难反射的private修饰来反射,其他访问权限的类似 */

    private final int namePrivate = 88;
    private final String name;
    private final int age;

    private UtillClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void showMessage(String name, int age) {
        System.out.println("Info " + name + ":" + age);
    }

    public void show() {
        System.out.println("共有方法!");
    }

}
