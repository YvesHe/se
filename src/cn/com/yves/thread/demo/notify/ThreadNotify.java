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
package cn.com.yves.thread.demo.notify;

/**
 * 这个线程用来唤醒 等待的线程.
 * 
 * @author Yves He
 * 
 */
public class ThreadNotify implements Runnable {
    private final Object lock;

    public ThreadNotify(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {// 同步代码块 用外部的锁

            System.out.println("开始唤醒线程!");
            long startTime = System.currentTimeMillis();
            lock.notify();// notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态
            try {
                Thread.currentThread().sleep(3000);// 虽然在这之前已经notify发送通知
                                                   // 但是等待的线程并不会马上执行而是要等待这个线程释放锁才执行,也及时说notify只发通知,不释放锁.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("唤醒结束,等待时间:"
                    + (System.currentTimeMillis() - startTime));

        }

    }

}
