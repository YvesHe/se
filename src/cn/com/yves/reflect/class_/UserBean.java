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
package cn.com.yves.reflect.class_;

public class UserBean {

    public UserBean() {// 如果是私有构造,就不能通过类的字节码后通过反射机制来new 该类的构造方法获取实例.
                       // ***这也是为什么喜欢把一个工具类定义成final类,然后私有构造,提供静态方法的原因.

    }

    private String name;
    private int age;

    public void showMessage() {
        System.out.println("你好!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
