/**   
 * Filename:    TestMyTask.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-28 下午7:57:59   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.threadpoolexecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestMyTask {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        TaskT task = new TaskT();

        Future<String> future = service.submit(task);// 互阻塞一段时间

        try {

            System.out.println(future.get(1000, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

class TaskT implements Callable<String> {// 中间是调用线程的时候 返回值的类型

    @Override
    public String call() throws Exception {

        Thread.sleep(5000);
        return "hello!";
    }

}