package multiThreadCommunication;

public class WaitNoticeDemo {
    private static volatile boolean flag = true;

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(), "Wait");
        wait.start();
        Thread notify = new Thread(new Notify(), "Notfify");
        notify.start();
        Thread.sleep(1);
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println("Wait.run Start1");
                        // wait()会释放对象的锁
                        lock.wait();
                        System.out.println("Wait.run Start2");
                    } catch (InterruptedException ignored) {
                    }
                }
                System.out.println("Wait.run End");
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) { // 因为wait()释放了锁，此时才能获取该对象的锁
                System.out.println("Notify.run Start");
                // 通知的时候并不会立刻释放锁，而是等到当前代码块退出的时候才会释放锁，wait() 方法才会继续执行
                lock.notify();
                flag = false;
                try {
                    Thread.sleep(2);
                    System.out.println("我睡眠了两秒，并不是执行notify()就释放了锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
