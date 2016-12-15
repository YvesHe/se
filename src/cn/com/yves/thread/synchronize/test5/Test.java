/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午3:43:59   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test5;

/**
 * 自定义一个锁: 用于同步,尽量减少开销量
 * 
 * @author Yves He
 * 
 */
public class Test {
    public static void main(String[] args) {

        Synchronized s = new Synchronized();

        Thread thread1 = new Thread(s, "sName1");
        Thread thread2 = new Thread(s, "sName2");

        // 先抢到锁的先执行
        thread1.start();
        thread2.start();
    }
}
