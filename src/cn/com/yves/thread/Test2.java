/**   
 * Filename:    Test2.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-23 上午11:10:21   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        final MyThread2 thread = new MyThread2();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread.showMessage1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread.showMessage2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();

        t1.join(0);

    }
}

class MyThread2 {

    public void showMessage1() throws InterruptedException {
        while (true) {

            System.out.println("1");
        }
    }

    public void showMessage2() throws InterruptedException {
        while (true) {
            System.out.println("2");

        }

    }

}