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
package cn.com.yves.object.clone.shallow;

/**
 * 
 * 深层次的clone:方法一
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        People people = new People("yves", 22, '男', "湖南");
        Father father = new Father("father", 50);
        people.setFather(father);

        People people2 = (People) people.clone();
        System.out.println(people2.getAddress() + people2.getAge()
                + people2.getName() + people2.getSex());
        Father cloneFather = people2.getFather();
        System.out.println(cloneFather.getName());

        System.out.println("*********");
        /* 改变clone对象里面的值,和clone对象里面对象的值 */
        people2.setName("yves2");// 改变克隆对象的值的普通值.
        cloneFather.setName("father2");// 改变克隆对象里面引用的值.

        System.out.println(people.getName());// 结果为: 还是原来的值yves
        System.out.println(people.getFather().getName());// 结果为:newFatherName
                                                         // 改变克隆后的引用的里面的值,原来people类里面的引用也改变了.

    }
}
