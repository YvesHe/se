/**   
 * Filename:    TestCyclicBarrier.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-23 上午11:58:35   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.elses;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);// 定义这组线程的个数.如果等待的个数到达设定的个数,这就开始全部同时执行.
        for (int i = 0; i < N + 1; i++)
            new Writer(barrier).start();
    }

    static class Writer extends Thread {
        private final CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName()
                    + "正在写入数据...");
            try {
                Thread.sleep(new Random().nextInt(10000)); // 以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName()
                        + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
                // cyclicBarrier.wait(10000); //如果等待超时了,就算没满 也可是全部执行,不再等待

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
            System.out.println();
        }
    }
}