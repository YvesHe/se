/**   
 * Filename:    Synchronized.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午2:17:19   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test5;

public class Synchronized implements Runnable {

    /* 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的instance变量（它得是一个对象）来充当锁 */
    private final byte[] lock = new byte[0];// 定义个byte[]类型 锁对象,它比Object lock =
                                            // new Object();更加节省空间.

    @Override
    public void run() {
        showMessage();

    }

    public void showMessage() {

        synchronized (lock) {// 同步代码块

            System.out.println("同步代码块!" + Thread.currentThread().toString());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
