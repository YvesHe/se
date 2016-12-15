/**   
 * Filename:    SynchronizeThread.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 上午10:26:06   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test1;

/**
 * 线程同步方式一:(使用同步代码块)
 * 
 * 当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
 * 
 * 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 
 * @author Yves He
 * 
 */
public class SynchronizeThread2 implements Runnable {

    /**
     * 同步方法(synchronized方法)
     */
    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().toString() + ":"
                    + Thread.currentThread().getName() + ":" + i);

            /* 休眠1s */
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
