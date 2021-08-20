package multiThreadCommunication;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    AtomicInteger num = new AtomicInteger(1);

    public void odd() {
        while (num.get() < 100) {
            if ((num.get() & 1) == 1) {
                // 奇数
                System.out.println("当前打印的奇数为：" + num.get());
//                 getAndIncrement()方法虽然会CAS将原始的num+1，但是返回的是var5，是原来的值
                num.getAndIncrement();
//                num.compareAndSet(num.get(), num.get() + 1);
            }
        }
    }

    public void even() {
        while (num.get() < 100) {
            if ((num.get() & 1) == 0) {
                System.out.println("当前打印的偶数为：" + num.get());
                num.getAndIncrement();
//                num.compareAndSet(num.get(), num.get() + 1);
            }
        }
    }

    public static void main(String[] args) {
        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        Thread t1 = new Thread(atomicIntegerDemo::odd, "奇数线程");
        Thread t2 = new Thread(atomicIntegerDemo::even, "偶数线程");
        t1.start();
        t2.start();
    }
}
