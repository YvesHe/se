/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-21 下午2:32:59   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {// 里面又很多方法, 待验证

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final Test test = new Test();

        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}