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

public class TestSynchronize1 {// 测试synchronize
                               // 同步时候,正在运行中的线程 在中断触发后 也是不能中断的

    public static void main(String[] args) throws InterruptedException {

        ThreadT1 run1 = new ThreadT1();
        Thread t1 = new Thread(run1, "t1");
        Thread t2 = new Thread(run1, "t2");

        t1.start();
        Thread.sleep(100);// 确保t1先获取锁

        t2.start();
        Thread.sleep(3000);

        t1.interrupt();// 手动调用中断，但是还是t1线程还是不会被中断

    }

}

class ThreadT1 implements Runnable {
    private final Object lock = new Object();

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        synchronized (lock) {
            System.out.println("start -- " + Thread.currentThread().getName());
            boolean falg = true;
            while (falg) {
            }
            System.out.println("end -- " + Thread.currentThread().getName());

        }

    }

}
