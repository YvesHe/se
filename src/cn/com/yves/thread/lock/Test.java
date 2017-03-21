/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-20 下午10:23:08   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();

        new Thread(t1).start();
        new Thread(t1).start();

    }

}

// 线程类
class ThreadTest implements Runnable {
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
            lock.unlock();
        }
    }

}
