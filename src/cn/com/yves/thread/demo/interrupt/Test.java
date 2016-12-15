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
package cn.com.yves.thread.demo.interrupt;

/**
 * isInterrupted() 判断线程是否中断
 * 
 * interrupt() 中断已经处于等待的线程,如果该线程不在等待状态,则没有效果.
 * 
 * @author Yves He
 * 
 */
public class Test {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread(), "tName");
        t.start();

        System.out.println(t.isInterrupted());// false没有中断

        t.interrupt();// 用来终止sleep

        System.out.println(t.isInterrupted());// true已经中断

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello1");
    }

}
