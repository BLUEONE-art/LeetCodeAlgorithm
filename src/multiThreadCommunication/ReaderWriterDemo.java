package multiThreadCommunication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ReaderWriterDemo {
    // 统计读者线程的个数，这个过程是互斥的
    public static Semaphore rCountMutex = new Semaphore(1);
    // 写者线程只能互斥的访问临界区
    public static Semaphore wDataMutex = new Semaphore(1);
    // 读者线程和写者线程需要公平的竞争锁
    public static Semaphore flag = new Semaphore(1);
    // 统计读者线程的个数，是一个共享资源
    public static Integer rCount = 0;
    // 定义读、写的变量
    public static Integer readAndWriter = 0;

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(5);
        ReaderWriterDemo readerWriterDemo = new ReaderWriterDemo();
        Thread writer = new Thread(readerWriterDemo::writer, "写者");
        Thread reader = new Thread(readerWriterDemo::reader, "读者");
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; i++) {
            service.submit(writer);
        }
        for (int i = 0; i < 10; i++) {
            service.submit(reader);
        }
    }

    public void writer() {
        while (true) {
            try {
                // P操作，此时读者线程再执行的话就会阻塞，保证读写互斥
                flag.acquire();
                // 写者线程也是要互斥的，执行P操作
                wDataMutex.acquire();
                System.out.println("写线程" + Thread.currentThread().getName() + "正在写数据...");
                readAndWriter++;
                System.out.println("写线程" + Thread.currentThread().getName() + "写后的数据为" + readAndWriter);
                wDataMutex.release();
                flag.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void reader() {
        while (true) {
            try {
                flag.acquire();
                rCountMutex.acquire();
                // 如果此时没有读者线程，要让写线程阻塞
                if (rCount == 0) {
                    wDataMutex.acquire();
                }
                rCount++;
                rCountMutex.release();
                flag.release();
                // 读操作
                System.out.println("写线程" + Thread.currentThread().getName() + "正在读数据..." + "读前的数据为" + readAndWriter);
                System.out.println("写线程" + Thread.currentThread().getName() + "读后的数据为" + readAndWriter);
                rCountMutex.acquire();
                rCount--;
                if (rCount == 0) {
                    wDataMutex.release();
                }
                rCountMutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
