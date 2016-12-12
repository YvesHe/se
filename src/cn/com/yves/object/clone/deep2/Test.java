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
package cn.com.yves.object.clone.deep2;

/**
 * 深层次clone二: 通过序列化和反序列化的方式来实现深层次的clone
 * 
 * 
 * 原理:
 * 
 * 在Java语言里深层复制一个对象，常常可以先使对象实现Serializable接口，
 * 
 * 然后把对象（实际上只是对象的一个拷贝）写到一个流中， 再从流中读出来，便可以重建对象。
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        People people = new People("yves", 22, '男', "湖南");
        Father father = new Father("father", 50);
        people.setFather(father);

        People peopleClone = (People) people.clone();
        Father fatherClone = peopleClone.getFather();

        fatherClone.setName("father2");

        System.out.println(people.getFather().getName());// 获取的值还是people原来的值:father,不受clone对象对值的改变.

    }
}
