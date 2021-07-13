package multiThreadCommunication;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo1 {
//    public static volatile Integer num = 0;

    AtomicInteger num = new AtomicInteger();

    public void add1() {
//        num++;
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        VolatileDemo1 demo1 = new VolatileDemo1();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    demo1.add1();;
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("num = " + demo1.num.get());
    }
}
