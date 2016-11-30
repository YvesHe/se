/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午4:03:46   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.object.clone;

/**
 * 调用自定义的clone方法.
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        CloneClass cc = new CloneClass();
        cc.setName("Yves");
        cc.setAge(22);

        CloneClass cloneObj = (CloneClass) cc.clone();// 克隆

        System.out.println(cloneObj.getName());
        System.out.println(cloneObj.getAge());
        cloneObj.setName("Yves2");// 改变克隆后对象的值,不会影响到原对象cc的值

        System.out.println(cc.getName());// Yves
        System.out.println(cloneObj.getName());// Yves2

        Object oo;

    }

}
