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
package cn.com.yves.thread.demo.lock;

/**
 * wait()方法会释放锁.
 * 
 * notify方法不会释放锁
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {
        byte[] lock = new byte[0];// 产生一个锁的对象,不用Object对象而用 byte[0]因为 资源开销小

        Thread wait1 = new Thread(new ThreadLock(lock));
        Thread wait2 = new Thread(new ThreadLock(lock));

        wait1.start();
        wait2.start();

        /*
         * 从运行结果: 打印出两行 "开始唤醒线程!可以知道,
         * 
         * wait1线程还没有唤醒结束之时将锁wait的时候,就已经将对象锁归还了,这时候wait2拿到锁了也进入了该方法"
         */

    }

}
