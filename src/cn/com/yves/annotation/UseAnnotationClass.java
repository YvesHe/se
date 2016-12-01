/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午4:26:28   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation;

import java.lang.annotation.Annotation;

/**
 * 在测试中,这是一个用了自定义注解的Java类
 * 
 * @author Yves He
 * 
 */
@YvesAnnotation(age = 23, value = "hello")
public class UseAnnotationClass {

    public static void main(String[] args) {
        Annotation aa = null;
        Class clazz = null;
    }

    @YvesAnnotation(age = 0, value = "")
    public void showMessag() {
        System.out.println("show Message!");
    }

}
