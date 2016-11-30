/**   
 * Filename:    CloneClass.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午4:02:08   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.object.clone;

public class CloneClass implements Cloneable {// 如果要能让该类能够clone,就要设置实现接口Cloneable(空接口,无方法.)

    private String name;
    private int age;

    @Override
    public Object clone() {// 原来的访问权限是protected,现在讲访问权限更改为public,方便以后在其他类中调用次clone方法.
                           // 将要抛出的异常在本类中来处理.
        CloneClass cc = null;
        try {
            cc = (CloneClass) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cc;
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

}
