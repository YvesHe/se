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

public class TestLock1 {// 测试lock 同步时候, "等待中的线程" 也就是睡眠的中的进程能 被立即中断"

    public static void main(String[] args) throws InterruptedException {
        ThreadRun1 tr = new ThreadRun1();
        Thread t1 = new Thread(tr, "t1");
        Thread t2 = new Thread(tr, "t2");

        t1.start();
        Thread.sleep(100);// 保证t1先抢到锁

        t2.start();
        Thread.sleep(3000);

        t2.interrupt();// 中断睡眠中的线程

    }
}

class ThreadRun1 implements Runnable {

    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        // lock.lock();//
        // 如果是lock时,也是不能中断等待中的线程的.只有使用lockInterruptibly方法时,在外部才能中断等待中的线程.

        try {
            lock.lockInterruptibly();// 这里如果是 "等待中的线程" 或 "获取锁后正在执行的中的线程"
                                     // 在外部是可以使用interrupt来中断异常的.然后立即进入异常处理
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
            lock.unlock();// 最后一定要释放锁, Lock
                          // 不像synchronize的可以在正常执行完成或发生异常时,自定的释放锁.
        }

    }

}
