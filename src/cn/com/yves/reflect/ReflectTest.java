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

public class ReflectTest {

    private static native void registerNatives();// 为什么native方法可以不要方法体.

    public static void main(String[] args) {
        Class clazz = UtillClass.class;

    }
}
