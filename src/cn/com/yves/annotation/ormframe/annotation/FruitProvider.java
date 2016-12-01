/**   
 * Filename:    FruitProvider.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-1 下午6:00:11   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-1 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation.ormframe.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     * 
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     * 
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     * 
     * @return
     */
    public String address() default "";
}