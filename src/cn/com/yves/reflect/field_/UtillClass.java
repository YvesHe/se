/**   
 * Filename:    User.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午7:51:18   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.field_;

/**
 * 这是一个等待被反射的类.
 * 
 * @author Yves He
 * 
 */
public class UtillClass extends SuperClass2 implements SuperInterface {

    /* 构造方法 */
    public UtillClass() {
    }

    /* 不同访问权限的属性 */
    String name;
    private final int namePrivate = 88;
    public int namePublic;
    protected int nameProtected;

}
