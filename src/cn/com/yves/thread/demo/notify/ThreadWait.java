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
 * 这个线程用来等待: 处于等待状态的线程 可以被 notify 通知唤醒,也可以被interrupt打断等待抛出InterruptedException异常
 * 
 * @author Yves He
 * 
 */
public class ThreadWait implements Runnable {
    private final Object lock;

    public ThreadWait(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {// 同步代码块 用外部的锁

            System.out.println("开始等待!");
            long startTime = System.currentTimeMillis();
            try {
                lock.wait();// wait()方法可以使调用该线程的方法"释放共享资源的锁"，然后从运行状态退出，进入等待队列，直到再次被唤醒。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待结束,等待时间:"
                    + (System.currentTimeMillis() - startTime));

        }

    }

}
