/**   
 * Filename:    ChildClass.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午1:51:11   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.keyword.static_;

/**
 * 静态的方法不能覆写，也不能被重写。总之，静态的没有重写！！！
 * 
 * @author Yves He
 * 
 */
public class ChildClass extends SuperClass {

    // 虽然写写了一个和父类中一样的静态方法,但是静态方法不能覆盖和重写,
    public static void ShowMessage() {// 改方法,在ChildClass引用调用时,会自动隐藏掉父类中的同名方法.
        System.out.println("子类中的同名static方法!");
    }

}
