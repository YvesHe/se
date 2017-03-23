/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-23 上午10:54:59   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread;

/**
 * 待分类, 这里是测试 Object 的wait方法, 尤其是wait()带参数的等待
 * 
 * 
 * 说明： 等待超时就会去参与资源竞争
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        final MyThread thread = new MyThread();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread.showMessage1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        Thread.sleep(1);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread.showMessage2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}

class MyThread {

    public synchronized void showMessage1() throws InterruptedException {

        this.wait(3000); // 实际调用的Object的方法,这里的意思的是该线程
                         // 等待5秒的时间不参与去抢锁,一旦超时,线程就变成可运行状态,只有一有资源锁,就立即参与竞争.(而不是超时就直接放弃了,无参方法是无限制的等待)
        System.out.println("1");
    }

    public synchronized void showMessage2() throws InterruptedException {

        Thread.sleep(10000);

        this.notify(); // 实际调用的Object的方法
        System.out.println("2");
    }

}