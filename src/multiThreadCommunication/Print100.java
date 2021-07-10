package multiThreadCommunication;

public class Print100 {
    // 定义共享变量
    public static Integer num = 0;
    public static final Object aLock = new Object();

    // 线程1：打印奇数
    public void odd() {
        while (num < 100) {
            synchronized (aLock) {
                if (num % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + " - " + num);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num++;
                    // 打印完奇数，唤醒在等待的偶数线程，这里不释放锁，执行完线程才会释放
                    aLock.notify();
                } else { // 如果是偶数，直接wait()让出锁
                    try {
                        aLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 线程2：打印偶数
    public void even() {
        while (num < 100) {
            synchronized (aLock) {
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + num);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num++;
                    aLock.notify();
                } else {
                    try {
                        aLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Print100 print100 = new Print100();
        Thread thread1 = new Thread(print100::odd, "我是奇数线程");
        Thread thread2 = new Thread(print100::even, "我是偶数线程");
        thread1.start();
        thread2.start();
    }

}
