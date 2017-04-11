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
     * 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致
     * 
     * （就是 private static final long serialVersionUID = 1L）。
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private char sex;
    private int age;

    public static String HELLO = "hello";// 静态变量, 序列化时候,不会保存

    private transient String tranString = "yves";// 定义transient 声明为瞬态,不序列化

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

    public String getTranString() {
        return tranString;
    }

    public void setTranString(String tranString) {
        this.tranString = tranString;
    }

}
