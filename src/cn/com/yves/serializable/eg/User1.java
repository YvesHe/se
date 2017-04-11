package cn.com.yves.serializable.eg;

/**   
 * Filename:    User1.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-11 下午1:54:40   
 * Description:  
 *
 * Author       Yves He 
 */
import java.io.Serializable;

/**
 * 实现了Serializable的javaBean
 * 
 * @author Yves He
 * 
 */
public class User1 implements Serializable {

    /**
     * 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致
     * 
     * （就是 private static final long serialVersionUID = 1L）,当然该值可以其他的值。
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}