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
package cn.com.yves.thread.synchronize.test3;

public class Synchronized {// 在同步方法中(不管是静态方法,还是普通的方法都是对本类或本类的实例上锁;
                           // 普通同步方法的锁相当于同步代码块的synchronized(this))

    /**
     * synchronized静态方法.
     */
    public synchronized static void showMesasgeStatic() {
        System.out.println("同步静态方法1!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * synchronized静态方法.
     */
    public synchronized static void showMesasgeStatic2() {
        System.out.println("同步静态方法2!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
