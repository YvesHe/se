/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-1 下午5:24:13   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-1 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation.ormframe;

public class Test {

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);// 传递的是使用了注解的类的字节码
    }

}
