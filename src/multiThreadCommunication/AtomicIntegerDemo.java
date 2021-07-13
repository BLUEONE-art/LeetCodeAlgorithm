package multiThreadCommunication;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    AtomicInteger num = new AtomicInteger();

    // 打印奇数
    public void odd() {
        while (num.get() < 1000) {
            if (num.get() % 2 != 0) {
                System.out.println("当前num的值为：" + num.get());
                num.getAndIncrement();
            }
        }
    }

    // 打印偶数
    public void even() {
        while (num.get() < 1000) {
            if (num.get() % 2 == 0) {
                System.out.println("当前num的值为：" + num.get());
                num.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        Thread thread1 = new Thread(atomicIntegerDemo::odd, "我是奇数线程");
        Thread thread2 = new Thread(atomicIntegerDemo::even, "我是偶数线程");
        thread1.start();
        thread2.start();
    }
}
