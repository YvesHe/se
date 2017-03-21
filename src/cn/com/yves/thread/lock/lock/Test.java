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
package cn.com.yves.thread.lock.lock;

public class Test {

    public static void main(String[] args) {

        // ThreadB tB = new ThreadB();
        // new Thread(tB).start();
        // new Thread(tB).start();

        // ThreadC tC = new ThreadC();
        // new Thread(tC).start();
        // new Thread(tC).start();

        /*
         * 测试ThreadE:lock.lockInterruptibly()　
         * 
         * 关于lock.lockInterruptibly() 的中断原理在interrupt包中
         */

        final ThreadE tE = new ThreadE();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tE.method1();
                } catch (InterruptedException e) {// 由于这个异常时在等待的线程被中断时,才会发生,
                                                  // 也就意味着该线程是等待状态,没有获取到锁,也就不需要在这里进行释放锁的曹邹
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }
}
