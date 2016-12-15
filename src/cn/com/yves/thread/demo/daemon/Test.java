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
package cn.com.yves.thread.demo.daemon;

public class Test {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread(), "tName");
        Thread t2 = new Thread(new MyThread(), "tName");

        t.setDaemon(true);// 将线程设置成为守护进程时,会自动在后台运行,为其他的进程提供便利,当所有的线程执行完毕后,该守护线程也会销毁,不需要手动销毁
                          // 本例子中:会等main线程执行完后退出"所有的守护进程"．
        t2.setDaemon(true);// setDaemon(true)必须在线程start()之前

        t.start();
        t2.start();

        try {
            Thread.sleep(10000);
            System.out.println("main线程结束!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
