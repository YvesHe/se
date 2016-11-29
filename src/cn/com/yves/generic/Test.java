/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午5:30:56   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.generic;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        EnumImpl<String> result = new EnumImpl<String>(list);
        while (result.hasMoreElements()) {
            String nextElement = result.nextElement();
            System.out.println(nextElement);
        }

    }

    public static <T> Enumeration<T> getEnum() {

        // 这里用到的是匿名对象? ,由于Enumeration是一个接口,所以要写出它的实现.
        return new Enumeration<T>() {

            @Override
            public boolean hasMoreElements() {
                return false;
            }

            @Override
            public T nextElement() {
                return null;
            }
        };
    }

}
