/**   
 * Filename:    ThreadLocalTest.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-20 下午5:12:23   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.threadlock;

import java.util.Random;

public class ThreadLocalTest {// ThreadLocal应用场景在对数据库连接 session的管理

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    MyThreadLocal local = new MyThreadLocal();
                    local.set("hello" + new Random().nextInt());

                    System.out.println(Thread.currentThread().getName() + "---"
                            + local.get());
                }
            }).start();
        }

    }
}

class MyThreadLocal {

    private final ThreadLocal<String> local = new ThreadLocal<String>() {// 观看源码发现
        // 不重新初始方式initialValue的时候,默认调用get()方法返回的null

        @Override
        protected String initialValue() {
            return " hello"; // 源码中 初始化后, 会将值set到local中,并发的时候,同一个线程只能访问到自己的
                             // -本地变量
        };

    };

    public void set(String message) {
        local.set(message);
    }

    public String get() {
        return local.get();
    }
}
