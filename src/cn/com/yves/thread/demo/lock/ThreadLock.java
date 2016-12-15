/**   
 * Filename:    Thread.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午5:45:21   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.demo.lock;

/**
 * 这个线程用来唤醒 等待的线程.
 * 
 * @author Yves He
 * 
 */
public class ThreadLock implements Runnable {
    private final Object lock;

    public ThreadLock(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {// 同步代码块 用外部的锁

            System.out.println("开始唤醒线程!");
            long startTime = System.currentTimeMillis();

            try {
                // Thread.sleep(3000);
                lock.wait();// wait()方法会释放锁.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("唤醒结束,等待时间:"
                    + (System.currentTimeMillis() - startTime));

        }

    }

}
