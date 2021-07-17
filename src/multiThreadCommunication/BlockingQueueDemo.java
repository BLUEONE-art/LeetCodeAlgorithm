package multiThreadCommunication;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列实现生产者消费者模型
 * 本质还是ReentrantLock，但是阻塞队列内部已经封装好了API，直接调用方法即可实现
 */
public class BlockingQueueDemo {
    public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        BlockingQueueDemo blockingQueueDemo = new BlockingQueueDemo();
        Thread producer = new Thread(blockingQueueDemo::producer, "生产者");
        Thread consumer = new Thread(blockingQueueDemo::consumer, "消费者");
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(producer);
        }
        for (int i = 0; i < 10; i++) {
            service.submit(consumer);
        }
    }

    public void producer() {
        try {
            while (true) {
                while (queue.size() == 10) {
                    System.out.println("缓冲区已满，请消费者消费数据！");
                }
                System.out.println("生产者" + Thread.currentThread().getName() + "正在生产数据......");
                queue.put(new Random().nextInt());
                System.out.println("生产后缓冲区数据数量：" + queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer() {
        try {
            while (true) {
                while (queue.size() == 0) {
                    System.out.println("缓冲区为空，请生产者生产数据！");
                }
                System.out.println("消费者" + Thread.currentThread().getName() + "正在消费数据......");
                queue.take();
                System.out.println("消费后缓冲区数据数量：" + queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者" + Thread.currentThread().getName() + "正在消费数据");
    }
}
