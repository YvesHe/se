/**   
 * Filename:    LockAPI.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-20 下午10:48:23   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPI {
}

/**
 * lock.lock(): 上锁
 * 
 * 
 * @author Yves He
 * 
 */
class ThreadA implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        System.out.println("in");// 两个线程可以几乎同时执行到这里,然后线面就是上锁了
        lock.lock();// 如果锁已被其他线程获取，则进行等待。

        try {
            System.out.println("Do somethins !");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();// 由于如果出现异常,系统不会自动释放锁,所以如果用了锁,
                          // 一定要在finally块中释放锁,这是与synchronize的不同,synchronize系统会自动释放锁
        }
    }

}

/**
 * lock.tryLock():锁可用，则获取锁(返回boolean)
 * 
 * ThreadB:用来测试tryLock()
 * 
 * API:仅在调用时锁为空闲状态才获取该锁。如果锁可用，则获取锁，并立即返回值 true。如果锁不可用，则此方法将立即返回值 false。
 * 
 * 心得:由于采用了sleep 在第二个线程调用tryLock() 获取不到锁,放回的是false所以Do Somethings start!只会执行一次.
 * 
 * 
 * @author Yves He
 * 
 */
class ThreadB implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        System.out.println("in");// 在上锁之前的代码都会被执行.

        if (lock.tryLock()) {
            try {
                System.out.println("Do Somethings start!");
                Thread.sleep(2000);
                System.out.println("Do Somethings end!");
            } catch (Exception e) {
                e.printStackTrace();// 异常要在内部捕获了,自己处理.
            } finally {
                lock.unlock();
            }
        }

    }
}

/**
 * 
 * lock.tryLock(10, TimeUnit.SECONDS): 在设置的等待时间里 来检测锁是否可用,可用就获取锁(返回boolean)
 * 
 * ThreadC:用来测试lock.tryLock(10, TimeUnit.SECONDS)
 * 
 * API:如果锁在给定的等待时间内锁是空闲的，并且当前线程未被中断，则获取锁。
 * 
 * 心得:功能与无参方法类似,主要这个方法有InterruptedException异常抛出,这里设置的10秒等待,第一个线程已经释放锁 所以可以看到两个Do
 * Somethings start!语句执行,只要在规定的超时时间里获取到锁就会执行try块中的代码
 * 
 * 
 * @author Yves He
 * 
 */
class ThreadC implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        System.out.println("in");// 在上锁之前的代码都会被执行.

        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {// TimeUnit.SECONDS
                                                     // 是设置字段是时间单位
                try {
                    System.out.println("Do Somethings start!");
                    Thread.sleep(2000);
                    System.out.println("Do Somethings end!");
                } catch (Exception e) {
                    e.printStackTrace();// 异常要在内部捕获了,自己处理.
                } finally {
                    lock.unlock();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

/**
 * lock.lockInterruptibly(): 中断锁(可以从外部中断正在等待中的线程,但是不能中断正在运行中的线程)
 * 
 * @author Yves He
 * 
 */
class ThreadE {

    final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    public void method1() throws InterruptedException {// 注意：　中断异常外抛了,能产生中断,说明是等待的线程,也就是没有获取到锁的线程
        lock.lockInterruptibly(); // 一般处理了为: 外抛异常InterruptedException

        try {
            // do something
        } catch (Exception e) {
        } finally {
            lock.unlock();// 在线程运行过程中产生了异常,要记得手动释放锁
        }

    }
}
