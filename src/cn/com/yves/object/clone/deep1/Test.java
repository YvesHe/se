/**   
 * Filename:    TestPeople.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-12 上午9:56:15   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-12 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.object.clone.deep1;

/**
 * 深层次clone一: 通过对要clone中引用继续clone
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        People people = new People("yves", 22, '男', "湖南");
        Father father = new Father("father", 50);
        people.setFather(father);

        People peopleClone;
        try {
            peopleClone = (People) people.clone();
            Father fatherClone = peopleClone.getFather();
            fatherClone.setName("father2");
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(people.getFather().getName());// 获取的值还是people原来的值:father,不受clone对象对值的改变.

    }
}
