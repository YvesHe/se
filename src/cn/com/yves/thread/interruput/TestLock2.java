/**   
 * Filename:    TestLock.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-21 上午10:04:43   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.interruput;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock2 {// 测试lock, "获取锁,正在运行的线程" 是不能被中断的,而且等到它运行结束了,中断也就没响应了.

    public static void main(String[] args) throws InterruptedException {
        ThreadRun2 tr = new ThreadRun2();
        Thread t1 = new Thread(tr, "t1");
        Thread t2 = new Thread(tr, "t2");

        t1.start();
        Thread.sleep(100);// 保证t1先抢到锁

        t2.start();
        Thread.sleep(3000);

        t1.interrupt();// 手动调用中断，但是还是t1线程还是不会被中断

    }
}

class ThreadRun2 implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        // lock.lock();//
        // 如果是lock时,也是不能中断等待中的线程的.只有使用lockInterruptibly方法时,在外部才能中断等待中的线程.

        try {
            lock.lockInterruptibly();//

            System.out.println("start -- " + Thread.currentThread().getName());
            // Thread.sleep(10000);
            boolean falg = true;
            while (falg) {
            }
            System.out.println("end -- " + Thread.currentThread().getName());

        } catch (InterruptedException e1) {
            System.out.println("enter  Exception");
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
