/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-12 上午9:32:25   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.string.string;

/**
 * 验证String的 intern方法.
 * 
 * @author Yves He
 * 
 */
public class TestStringIntern {
    public static void main(String[] args) {
        StringBuilder sb = null;

        String s1 = new String("ab");// 产生的String 对象在heap中

        String s3 = s1.intern();// 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（用
                                // equals(Object) 方法确定），则返回池中的字符串。否则，将此 String
                                // 对象添加到池中，并返回此 String
                                // 对象的引用(简单地啊你讲就是如果池中没有就会把该对象添加到池中然后返回该池中对象的引用)

        String s2 = "ab";// ""回直接去池中找,有这返回已经存在的,没有就在池中新建了了然后返回引用

        String s4 = new String("a") + new String("b");// 原理:(new
                                                      // StringBuilder(String.valueOf(new
                                                      // String("a")))).append(new
                                                      // String("b")).toString();
                                                      // toString里面还是new的String,所以又是新的引用.
        String s5 = s4.intern();// 去常量池中找,上面s3已经存了.

        System.out.println(s1 == s2);// false jdk1.6
        System.out.println(s3 == s2);// true; jdk1.6
        System.out.println(s5 == s2);// true; jdk1.6

        // 注意: jdk1.7中
        // intern方法不会再复制实例到常量池值,而是在调用intern方法时在常量池值中记录首次出现实例的引用,并返回该引用
    }

}
