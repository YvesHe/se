/**   
 * Filename:    Test2.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-22 下午6:25:30   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock.container.synchronize;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用阻塞队列(ArrayBlockingQueue: 内部实现了同步代码)来实现 生产者--消费者
 * 
 * @author Yves He
 * 
 */
public class TestProducerAndConsumer2 {
    private final int queueSize = 10;
    private final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(
            queueSize);

    public static void main(String[] args) {
        TestProducerAndConsumer2 testProducerAndConsumer2 = new TestProducerAndConsumer2();
        Producer producer = testProducerAndConsumer2.new Producer();
        Consumer consumer = testProducerAndConsumer2.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    queue.take();// 方法内部已经自己做了同步代码处理
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    queue.put(1);// 方法内部已经自己做了同步代码处理
                    System.out.println("向队列取中插入一个元素，队列剩余空间："
                            + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}