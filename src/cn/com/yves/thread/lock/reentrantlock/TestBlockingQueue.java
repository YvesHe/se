/**   
 * Filename:    TestBlockingQueur.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-22 下午4:00:40   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock.reentrantlock;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 阻塞队列的 生产者-消费者
 * 
 * 以及reentrantlock的 Condition的使用
 * 
 * @author Yves He
 * 
 */
public class TestBlockingQueue {

    private final int queueSize = 10;
    private final PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            queueSize);
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        TestBlockingQueue test = new TestBlockingQueue();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    /* 消费者 */
    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll(); // 每次移走队首元素,然后通知 队列没有满
                    notFull.signal();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /* 生产者 */
    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1); // 每次插入一个元素
                    notEmpty.signal();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："
                            + (queueSize - queue.size()));
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
