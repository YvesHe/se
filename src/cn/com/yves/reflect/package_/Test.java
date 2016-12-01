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
package cn.com.yves.reflect.package_;

/**
 * 反射包,和包的常用API
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        Class<UtillClass> clazz = UtillClass.class;// 因为已经是是UtillClass的泛型,
                                                   // 不知道泛型的情况,可以直接用 Class

        Package package1 = clazz.getPackage();// 返回该位于的包
        System.out.println(package1.getName());

        String specificationTitle = package1.getSpecificationTitle();
        System.out.println(specificationTitle);
    }
}
