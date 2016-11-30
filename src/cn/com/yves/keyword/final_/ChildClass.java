/**   
 * Filename:    ChildClass.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午2:44:31   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.keyword.final_;

/**
 * 如果在子类中定义的一个方法，其名称、返回类型及参数签名正好与父类中某
 * 
 * 个方法的名称、返回类型及参数签名相匹配，那么可以说，子类的方法覆盖了父
 * 
 * 类的方法。
 * 
 * @author Yves He
 * 
 */
public class ChildClass extends SuperClass {
    /* 方法覆要点 方法名称,返回值类型,和参数签名与父类相同,但是与其他的修饰关键词无关. */

    // showmessage1() 该final方法不能覆盖

    @Override
    public void showmessage2() {// 覆盖方法时候,访问权限只能比父类权限相等或更大.
    }

}
