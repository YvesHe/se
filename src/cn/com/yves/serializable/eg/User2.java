/**   
 * Filename:    User2.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-11 下午2:15:59   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.serializable.eg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 实现接口Externalizable的javaBean
 * 
 * 注意:要重写Externalizable接口中两个方法:writeExternal, readExternal
 * 
 * @author Yves He
 * 
 */
public class User2 implements Externalizable {

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);// name 和age 是否有顺序
        out.writeInt(age);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        name = (String) in.readObject();// 什么时候是用readObject, 读取的时候是否有顺序
        age = in.readInt();

    }

}
