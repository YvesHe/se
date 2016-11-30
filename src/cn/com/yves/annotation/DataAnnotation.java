/**   
 * Filename:    DataAnnotation.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午4:56:11   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation;

/**
 * 定义一个"元数据Annotation": 包含成员变量的
 * 
 * @author Yves He
 * 
 */
public @interface DataAnnotation {

    /* 理解:参数类型,变量名 */
    String name() default "Yves";

    int age();

}
