/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午2:18:21   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test3;

/**
 * synchronized同步静态方法:
 * 
 * 也是先获得锁的先执行,其他的等待.
 * 
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        /* 创建两个线程,线程中调用同一个类的synchronized静态方法 */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Synchronized.showMesasgeStatic();
            }

        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Synchronized.showMesasgeStatic2();// 不管调用的方法是同一个还是不同的(showMesasgeStatic()或者showMesasgeStatic2())
                                                  // 都会冲突,需要等待.
            }

        });

        /* 启动线程: 结果也是有一个线程要等待有锁线程先执行完 */
        t1.start();
        t2.start();

    }

}
