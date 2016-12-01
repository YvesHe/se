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
package cn.com.yves.reflect.method_;

/**
 * 这是一个等待被反射的类.
 * 
 * @author Yves He
 * 
 */
public class UtillClass extends SuperClass2 {

    /* 不同访问权限的方法 */
    void showMessage() {// 缺省的访问权限
        System.out.println("showMessage");
    }

    private void showMessagePrivate() {
        System.out.println("showMessagePrivate");
    }

    private void showMessagePrivate2(String name, int age) {
        System.out.println("showMessagePrivate " + name + ":" + age);
    }

    protected void showMessageProtected() {
        System.out.println("showMessageProtected");

    }

    public void showMessagePublic() {
        System.out.println("showMessagePublic");
    }

}
