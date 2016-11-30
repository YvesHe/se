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
import java.lang.reflect.InvocationTargetException;

/**
 * 暴力反射
 * 
 * @author Yves He
 * 
 */
public class Test {
    public static void main(String[] args) {
        Class clazz = UtillClass.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();// 获取此类中所有声明的构造方法.(不包括父类中的)
        System.out.println(constructors.length);
        constructors[0].setAccessible(true);// 打开构造访问的权限,跳过虚拟机的检查

        try {
            UtillClass uc = (UtillClass) constructors[0].newInstance(null, 0); // 参数引用型可以为null,原始型可以为0;
            uc.showMessage();
            uc.showMessageProtected();
            uc.showMessagePublic();

        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
