package multiThreadCommunication;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * 互斥：生产者和消费者每次只有一个能够操作临界区资源
 * 同步：
 * 缓冲区没有数据时，消费者只能等待生产者生产数据
 * 缓冲区满了时，生产者只能等待消费者消费数据，缓冲区不为满时才能生产数据
 */

public class SynchronizedProducerConsumerDemo {
    // 数据缓冲区 + 临界资源，使用链表模拟
    public static LinkedList<Integer> list = new LinkedList<>(Collections.singleton(10));

    public static void main(String[] args) {
        SynchronizedProducerConsumerDemo synchronizedProducerConsumerDemo = new SynchronizedProducerConsumerDemo();
        Thread producer = new Thread(synchronizedProducerConsumerDemo::producer, "生产者A");
        Thread consumer = new Thread(synchronizedProducerConsumerDemo::consumer, "消费者B");
        producer.start();
        consumer.start();
    }

    // 生产数据
    public void producer() {
        while (true) {
            synchronized (list) {
                try {
                    // 缓冲区不为空或者满了时，直接释放锁
                    while (list.size() > 0) {
                        System.out.println("此时缓冲区有数据，请消费者消费数据");
                        list.wait();
                    }
                    // 只有缓冲区有空位才会进行消费
                    System.out.println("我是生产者线程：" + Thread.currentThread().getName() + "，正在生产数据！生产之前缓冲区的资源数量为：" + list.size());
                    // 生产完成，缓冲区资源+1
                    list.addFirst(new Random().nextInt());
                    System.out.println("生产完成后缓冲区中的资源数量为：" + list.size());
                    // 唤醒消费者线程
                    list.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 消费数据
    public void consumer() {
        // 保证同步代码每次只有一个线程能执行
        synchronized (list) {
            try {
                // 如果缓冲区为空，让出锁
                while (list.size() == 10) {
                    System.out.println("此时缓冲区已经没有数据了，请生产者生产！");
                    list.wait();
                }
                // 只有缓冲区有数据才会进行消费
                System.out.println("我是消费者线程：" + Thread.currentThread().getName() + "，正在消费数据！消费之前缓冲区的资源数量为：" + list.size());
                // 消费完成，缓冲区资源-1
                list.removeLast();
                System.out.println("消费完成后缓冲区中的资源数量为：" + list.size());
                // 唤醒生产者线程
                list.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
