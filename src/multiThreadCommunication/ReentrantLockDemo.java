package multiThreadCommunication;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock实现生产消费者模型
 */
public class ReentrantLockDemo {
    // 定义共享资源
    public static LinkedList<Integer> list = new LinkedList<>();
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition full = lock.newCondition();
    public static Condition empty = lock.newCondition();

    CountDownLatch countDownLatch = new CountDownLatch(3);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread producer = new Thread(reentrantLockDemo::producer, "生产者线程");
        Thread consumer = new Thread(reentrantLockDemo::consumer, "消费者线程");
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(producer);
        }
        for (int i = 0; i < 10; i++) {
            service.submit(consumer);
        }
    }

    // 生产者
    public void producer() {
        while (true) {
            // 互斥地拿到锁，再操作临界区
            lock.lock();
            try {
                while (list.size() == 10) {
                    System.out.println(Thread.currentThread().getName() + ": 缓冲区已满，请消费者消费并让出了锁");
                    // 让出锁，等消费者线程获取锁
                    full.await();
                    System.out.println(Thread.currentThread().getName() + ": 消费者已消费完成，请生产者继续生产");
                }
                System.out.println("线程" + Thread.currentThread().getName() + "正在生产数据......");
                list.addFirst(new Random().nextInt());
                System.out.println("线程" + Thread.currentThread().getName() + "已生产了" + list.size() + "个数据了");
                empty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 显式地释放锁
                lock.unlock();
            }
        }
    }

    // 消费者
    public void consumer() {
        while (true) {
            lock.lock();
            try {
                while (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + ": 缓冲区无数据，请生产者生产数据并让出了锁");
                    empty.await();
                    System.out.println(Thread.currentThread().getName() + ": 生产者生产完数据了，请消费者消费");
                }
                System.out.println("消费者正在消费数据......");
                list.removeLast();
                System.out.println("线程" + Thread.currentThread().getName() + "消费完数据后剩余" + list.size() + "个数据");
                full.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
