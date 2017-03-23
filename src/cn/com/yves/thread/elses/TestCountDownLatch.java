/**   
 * Filename:    TestCountDownLatch.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-23 上午11:42:46   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.elses;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(2);

        System.out.println("主线程:等待2个子线程执行完毕...");

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程:"
                            + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000);
                    System.out.println("子线程:"
                            + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程:"
                            + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(500);
                    System.out.println("子线程:"
                            + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程:"
                            + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(5000);
                    System.out.println("子线程:"
                            + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            latch.await(); // 这句话 只能在写在子线程启动后面,否则一直在前面就等待了.
            System.out.println("主线程:2个子线程已经执行完毕");
            System.out.println("主线程:继续执行主线程");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
