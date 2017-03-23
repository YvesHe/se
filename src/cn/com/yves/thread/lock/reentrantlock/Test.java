/**   
 * Filename:    TEst.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-21 下午2:07:52   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现接口 Lock :　　大部分方法在Lock包下验证了,这里只验证小部分方法... 未完待续
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {
        ThreadT t = new ThreadT();

        new Thread(t, "t1").start();
        new Thread(t, "t2").start();
        new Thread(t, "t3").start();
        new Thread(t, "t4").start();
        new Thread(t, "t5").start();
        new Thread(t, "t6").start();

    }
}

/* 创建一个公平锁 */
class ThreadT implements Runnable {
    Lock lock = new ReentrantLock(true); // 创建一个公平锁, 公平锁即尽量以请求锁的顺序来获取锁.
                                         // 无参数构造默认是非公平锁.

    @Override
    public void run() {
        lock.lock();
        try {
            // do somethings;
            System.out.println(Thread.currentThread().getName());// 打印出来的结果是按请求顺序来的
        } catch (Exception e) {
            // 处理异常
        } finally {
            lock.unlock();
        }

    }
}
