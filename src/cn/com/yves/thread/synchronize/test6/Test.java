/**   
 * Filename:    Teet.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-15 下午4:00:55   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-15 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.thread.synchronize.test6;

public class Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Synchronized.showMessage();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Synchronized.showMessage2();
            }
        });

        t1.start();
        t2.start();

    }

}
