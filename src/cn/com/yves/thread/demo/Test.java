/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-13 下午7:42:37   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-13 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.demo;

/**
 * 实现多线程的两种方式: 继承自Thread类,和实现Runnable接口
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        /* 1.继承Thread类的线程调用 (Thread类本质也是是实现了Runnable接口) */
        MyThread mThread = new MyThread();
        mThread.start();// 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。

        /* 2.实现接口Runnable的线程调用 */
        MyRunnable mRunnable = new MyRunnable(); // 这里的概念:实现某个接口,那么该类可以就是该接口的引用,多肽的概念;
                                                 // Runnable mRunnable=new
                                                 // MyRunnable();
        new Thread(mRunnable).start();
    }
}
