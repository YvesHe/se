/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-21 上午9:43:20   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.interruput;

public class TestSynchronize2 {// 测试synchronize
                               // 同步时候 " 等待中的线程": 总之使用
                               // synchronized来同步时,不管线程是运行状态还是,还是等待状态 都是不能被中断的;

    public static void main(String[] args) throws InterruptedException {

        final ThreadT2 run1 = new ThreadT2();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                run1.method1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                run1.method2();
            }
        }, "t2");

        t1.start();
        Thread.sleep(100);// 确保t1先获取锁

        t2.start();
        Thread.sleep(1000);

        t2.interrupt();// 手动调用中断，但是还是t2线程还是不会被中断

    }
}

class ThreadT2 {
    private final Object lock = new Object();

    public void method1() {

        synchronized (lock) {
            System.out.println("start -- " + Thread.currentThread().getName());
            boolean falg = true;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end -- " + Thread.currentThread().getName());
        }

    }

    public void method2() {

        synchronized (lock) {
            System.out.println("start -- " + Thread.currentThread().getName());
            boolean falg = true;
            while (falg) {
            }
            System.out.println("end -- " + Thread.currentThread().getName());
        }

    }
}
