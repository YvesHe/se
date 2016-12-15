/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午5:34:47   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.test;

public class Test {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadT(), "t1");
        Thread t2 = new Thread(new ThreadT(), "t2");

        t1.setPriority(1);
        t2.setPriority(5);// 优先级高的先执行的几率大

        t1.start();
        t2.start();

    }

}
