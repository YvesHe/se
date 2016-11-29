/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午3:39:20   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.generic.clazz;

public class Test {

    // 泛型定义<T>在返回值T前面
    public static <T> T showHello(T t) {// 静态的泛型方法：
        System.out.println("Hello!" + t.toString());
        return t;
    }

    public static void main(String[] args) {

        Generic<Integer> integerBox = new Generic<Integer>("test");// <>里面是传递的泛型值, ()
                                                             // 传递的是构造方法的参数.互不影响.
        Generic<String> stringBox = new Generic<String>("test");

        integerBox.add(new Integer(10));// 调用方法的时候 ,就只传入T型变量了,由产生对象时就决定了.
        stringBox.add(new String("Hello World"));

        System.out.println("Integer Value :" + integerBox.get());
        System.out.println("Integer Value :" + stringBox.get());

        // 调用静态的泛型方法
        String str = showHello("nihao");
        System.out.println(str);

    }
}
