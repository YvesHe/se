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
package cn.com.yves.thread.threadlocal;

public class ThreadLocalTest {// ThreadLocal应用场景在对数据库连接 session的管理
    static Session sessionA = null;
    static Session sessionB = null;

    public static void main(String[] args) throws InterruptedException {

        final TThreadLocal DBUtil = new TThreadLocal();// 创造单例条件(数据库管理类,单例)

        // 线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                Session session = DBUtil.getSession();
                Session session2 = DBUtil.getSession();
                sessionA = DBUtil.getSession();

                System.out.println(session == session2);// true
                                                        // 同一个线程里面从ThreadLocal中获取的同一个对象session
            }
        }).start();

        // 线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                Session session = DBUtil.getSession();
                Session session2 = DBUtil.getSession();
                sessionB = DBUtil.getSession();
                System.out.println(session == session2);// true
                                                        // 同一个线程里面从ThreadLocal中获取的同一个对象session
            }
        }).start();

        Thread.sleep(1000);// 为了让sessionA 和 sessionB 都能赋值成功,延时下
        System.out.println(sessionA);
        System.out.println(sessionB);
        System.out.println(sessionA == sessionB);// false 不同的线程获取的值,是不相同的

    }
}

class TThreadLocal {

    private final ThreadLocal<Session> localSession = new ThreadLocal<Session>() {// 观看源码发现
        // 不重新初始方式initialValue的时候,默认调用get()方法返回的null

        @Override
        protected Session initialValue() {
            return new Session(); // 源码中 初始化后, 会将值set到local中,并发的时候,同一个线程只能访问到自己的
                                  // -本地变量
        };
    };

    public Session getSession() {
        Session session = localSession.get();
        if (session == null) {
            localSession.set(new Session());
        }
        return localSession.get();
    }

}
