/**   
 * Filename:    Enumer.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-28 下午8:11:34   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-28 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.enumeration;

/**
 * 在JDK1.5 之前，我们定义常量都是： public static fianl....
 * 
 * 有了枚举后，可以把相关的常量分组到一个枚举类型里，而且枚举提供了比常量更多的方法。
 * 
 * @author Yves He
 * 
 */

public class Test {

    public static void main(String[] args) {

        // 输出某一枚举的值
        System.out.println(Color.RED.getName());
        System.out.println(Color.RED.getIndex());

        // 遍历所有的枚举
        for (Color color : Color.values()) {
            System.out.println(color + "  name: " + color.getName()
                    + "  index: " + color.getIndex());
        }

    }

}
