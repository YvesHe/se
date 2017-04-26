/**   
 * Filename:    TestStringBuffer.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-26 下午4:20:33   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.string.stringbuffer;

public class TestStringBuffer {

    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);// jdk1.7:true jdk1.6: false

        String str3 = new StringBuilder("ja").append("va").toString();// 可以理解在new
                                                                      // String("java")之前常量池就有了"java",str3.intern()返回的是之前的引用
        System.out.println(str3.intern() == str3);// jdk1.7:false jdk1.6:false

    }

    // 分析原理:
    // 1.jdk1.7中 intern方法不会再复制实例到常量池值,而是在调用intern方法时在常量池值中记录首次出现实例的引用,并返回该引用
    // 2. "java" 是关键字 常量池中早就存在了

}
