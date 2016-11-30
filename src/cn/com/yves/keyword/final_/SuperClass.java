/**   
 * Filename:    SuperClas.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午2:42:41   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.keyword.final_;

public class SuperClass {

    public final void showmessage() {// 定义一个final方法,该方法在子类中不能被覆盖(重写)
        System.out.println("父类中的final方法!");
    }

    protected void showmessage2() {// 定义一个普通的方法
        System.out.println("父类中的final方法!");
    }

}
