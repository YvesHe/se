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
package cn.com.yves.object.clone.shallow;

public class People implements Cloneable {// 1.要被clone的类必须要实现接口Cloneable;
    private String name;
    private int age;
    private char sex;
    private String address;
    private Father father;// 应用

    public People(String name, int age, char sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public Object clone() {// 2.复写clone方法,将异常内部处理(建议异常放在外部处理.),將返回的object对象具体化为本类对象.将返回的权限protected改为public权限

        People people = null;
        try {
            people = (People) super.clone();//
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
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
