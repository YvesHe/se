/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-9 下午3:10:21   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-9 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.object.clone.deep1;

/**
 * 该类是对深层次的clone一些理解
 * 
 * @author Yves He
 * 
 */
public class TestElse {
    public static void main(String[] args) {
        // 查看源代码，我们可知，String类并没有重载Object类的clone方法。虽然，String和Object都在java.lang包中，
        // 但是我们的测试类Test不在java.lang包中，因message.clone()是访问不到protect方法.

        // 经过测试:
        // 在父类中有protected方法,只能在子类的代码内部(比如在子类中产生了子类对象,然后调用父类方法.)
        // 和同包下其他类中通过父类的实例来访问.

        Object object;
        String message = "yves";
    }
}
