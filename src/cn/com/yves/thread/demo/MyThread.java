/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-13 下午2:49:41   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-13 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.demo;

/**
 * 
 * 
 * 第一种方式: 继承自Thread类
 * 
 * @author Yves He
 * 
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("这是继承thread类的线程!");
    }

}
