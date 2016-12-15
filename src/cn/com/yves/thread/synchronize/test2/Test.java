/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 上午11:06:16   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test2;

/**
 * 多线程调用＂同步方法和非同步方法＂:
 * 
 * 结论:
 * 
 * 1.非同步方法直接调用,不受锁的限制,不得带.
 * 
 * 2.同步方法,如果公用一把锁,则要等待有锁的线程先执行完,再获取锁执行
 * 
 * @author Yves He
 * 
 */
public class Test {
    public static void main(String[] args) {
        final Synchronize t1 = new Synchronize();

        /* 1.调用同步方法 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.showHello2();// 有锁的方法
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.showHello2();// 显示等待,如果1先抢到锁,就等待 1.调用同步方法中的线程执行完再执行.
            }
        }).start();

        /* 2.调用非同步方法 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.showHello1();// 非同步方法,不等待,直接执行.
            }
        }).start();

    }
}
