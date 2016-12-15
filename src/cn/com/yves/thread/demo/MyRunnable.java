/**   
 * Filename:    MyRunable.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-13 下午7:43:32   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-13 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.demo;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("这是实现runnable方式的线程.");
    }

}
