/**   
 * Filename:    User.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午8:25:34   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.serializable;

import java.io.Serializable;

/**
 * 实现接口 Serializable,使得该类的对象可以序列化
 * 
 * @author Yves He
 * 
 */
public class UserBean implements Serializable {
    /**
     * long 型的serialVersionUID是干嘛的?
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private char sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
