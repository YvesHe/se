/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午2:56:16   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test4;

/**
 * 比较 "同步方法"和"同步代码块"的锁
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        final Synchronized s = new Synchronized();
        final Synchronized s4 = new Synchronized();// 另外新建一个对象

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Synchronized.showMessageSynStatic();// synchronized静态方法
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.showMessageSyn();// synchronized非静态方法
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.showMessageSynPiece();// 普通方法+synchronized代码块
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                s4.showMessageSyn();// synchronized非静态方法(新建的一个对象)
            }
        });

        t1.start();// synchronized静态方法的锁不是调用该方法的对象,而是 该类是字节码,
                   // eg: Synchronized.class

        /* t2和t3是用的是同一个对象. */
        t2.start();
        t3.start();// 当方法块是的锁是 synchronized (this)的时候也是要等待的,因为跟t1 ,t2
                   // 是共用的一把锁,如果锁不是this,则不要等待t2

        t4.start();// 不是调用同一个对象中的带锁的方法,所以与s的锁无关,只与s4的锁有关

        /**
         * 结果: t1 ,t4 (t2,t3中随机一个) 先一起出来
         * 
         */

    }
}
