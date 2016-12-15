/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 上午10:26:36   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test1;

/**
 * 方式一:同步代码块
 * 
 * @author Yves He
 * 
 */
public class Test {
    public static void main(String[] args) {

        SynchronizeThread st = new SynchronizeThread();

        new Thread(st, "A").start();// 1.当调用的是同一个线程的对象被同步的代码块,就要实现线程同步:"你先说,我后说"
        new Thread(st, "B").start();

    }

}
