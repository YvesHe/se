/**   
 * Filename:    TestInteger.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-11 上午9:24:21   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.basetype;

public class TestInteger {

    public static void main(String[] args) {
        testParseInt();

        Integer i = null;

    }

    public static void testConstructor() {
        Integer i = new Integer(10);
        i = 5; // 通过反编译可以知道其中i=5操作时，编译器会转成i =
               // Integer.valueOf(5);执行。

    }

    public static void testParseInt() {// 将制定进制的数转换成 10 进制,
        Integer.parseInt("9");// Integer.parseInt("a",10) 默认

        int parse = Integer.parseInt("a", 16);// 16进制的a转换成 10进制为10
        System.out.println(parse);// 10
    }

}
