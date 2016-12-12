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
package cn.com.yves.object.clone.deep1;

/**
 * 
 * @author Yves He
 * 
 */
public class People implements Cloneable {// 1.要被clone的类必须要实现接口Cloneable,并且其中的引用类型也需要实现接口Cloneable

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
    public Object clone() throws CloneNotSupportedException {
        People people = null;

        people = (People) super.clone();
        people.father = (Father) father.clone();// 将本类中的引用成员继续clone后赋值给本类的clone对象

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
