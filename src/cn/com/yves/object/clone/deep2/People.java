/**   
 * Filename:    People.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-12 上午9:52:00   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-12 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.object.clone.deep2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 深层次的clone:方法二(通过序列化)
 * 
 * @author Yves He
 * 
 */
public class People implements Serializable {// 1.要被clone的类必须要实现接口序列化接口Serializable,并且其中的引用类型也需要实现序列化

    private String name;
    private int age;
    private char sex;
    private String address;
    private Father father;// 引用

    public People(String name, int age, char sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public Object clone() {

        People people = null;
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        try {
            // 将对象写到流中
            out = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(out);// ObjectOutputStream没有关流方法?
            objectOut.writeObject(this);

            // 将数据从流中取出来
            in = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream objectInput = new ObjectInputStream(in);
            people = (People) objectInput.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return people;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

}
