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
package cn.com.yves.thread.synchronize.test4;

public class Synchronized {

    /**
     * synchronized静态方法.
     */
    public synchronized static void showMessageSynStatic() {
        System.out.println("同步静态方法:" + Thread.currentThread().toString());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * synchronized 普通方法.
     */
    public synchronized void showMessageSyn() {// 此时
                                               // synchronized锁定的是调用这个同步方法的对象.
                                               // 但是这个对象所属的Class所产生的另一对象却可以任意调用这个被加了synchronized关键字的方法。
                                               // 该同步方法此时相当于synchronized (this)
                                               // this也是指代的是调用该方法的对象.
        System.out.println("普通同步方法:" + Thread.currentThread().toString());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 普通方法+synchronized代码块
     */
    public void showMessageSynPiece() {
        synchronized (this) {// 代码块的锁:
                             // 可以是任意的对象,但是用的this的时候,那么锁就跟方法锁是一样的都是能调用该方法的对象
                             // 当不是this时候 就与调用该方法的对象无关了.
            System.out.println("t4:" + "synchronized代码块:"
                    + Thread.currentThread().toString());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 普通未同步的方法:可以随便调用,与锁无关.
     */
    public void showMessage() {
        System.out.println("普通的方法!");
    }

}
