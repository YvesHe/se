/**   
 * Filename:    YvesAnnotation.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午4:37:49   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解YvesAnnotation:
 * 
 * Annotation只有成员变量，没有方法。Annotation的成员变量在Annotation定义中以“无形参的方法”形式来声明，
 * 其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
 * 
 * @author Yves He
 * 
 */
@Documented
// javaDoc时生成帮助文档
@Inherited
// 设置该注解是否可以继承,(如果某个类A上用了该注解,B继承A,B类也就使用了该注解)
@Target(value = { ElementType.METHOD, ElementType.TYPE })
// 限制该注解定义的位置: 比如METHOD为定义在方法上.
@Retention(RetentionPolicy.RUNTIME)
// 用于指定Annotation可以保留多长时间,有Source ,class,runtime
// 参数可选,如果是在代码运行时希望注解还在,所以一般是设置成RUNTIME
public @interface YvesAnnotation {// 跟接口定义很像,在原有interface关键字前增加@符号

    /* 格式: 无形餐,也就是么有参数 */

    String name() default "Yves"; // 以方法的形式来定义成员变量,指定默认值为"Yves"

    int age();// 如果没有指定默认的值,则在使用该注解的时候会强制要求赋值

    String value();// 如果参数名为value是,在外部调用该注解的时可以不用key=vale的形式,而是直接写value(只适用于该注解只有这一个参数时可以这样做)

}
