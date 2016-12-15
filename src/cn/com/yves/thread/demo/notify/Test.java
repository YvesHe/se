/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午5:34:47   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.demo.notify;

/**
 * 手动让一个线程等待,然后手动去唤醒该线程.
 * 
 * 要点:
 * 
 * 1只能在同步方法/同步代码块中调用wait()方法,和wait()一样，notify()也要在同步方法/同步代码块中调用.
 * 
 * 2.wait()使线程停止运行，notify()使停止运行的线程继续运行。
 * 
 * 3.注意:如果wait()方法和notify()/notifyAll()方法不在同步方法/同步代码块中被调用，
 * 
 * 那么虚拟机会抛出java.lang. IllegalMonitorStateException，注意一下。
 * 
 * @author Yves He
 * 
 */
public class Test {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        byte[] lock = new byte[0];// 产生一个锁的对象,不用Object对象而用 byte[0]因为 资源开销小

        Thread wait = new Thread(new ThreadWait(lock));
        Thread notify = new Thread(new ThreadNotify(lock));
        wait.start();

        // 3秒之后唤醒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notify.start();

    }

}
