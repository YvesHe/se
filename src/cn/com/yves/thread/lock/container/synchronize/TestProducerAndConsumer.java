/**   
 * Filename:    AAA.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-22 下午6:17:30   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.lock.container.synchronize;

import java.util.PriorityQueue;

/**
 * 经典的生产者--消费者模式 (PriorityQueue 内部没有做同步)
 * 
 * 手动用 wait 和notify 来实现线程间的通信.
 * 
 * @author Yves He
 * 
 */
public class TestProducerAndConsumer {
    private final int queueSize = 10;
    private final PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            queueSize);

    public static void main(String[] args) {
        TestProducerAndConsumer test = new TestProducerAndConsumer();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

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
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll(); // 每次移走队首元素
                    queue.notify();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
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
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1); // 每次插入一个元素
                    queue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："
                            + (queueSize - queue.size()));
                }
            }
        }
    }
}