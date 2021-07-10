package multiThreadCommunication;

public class VolatileDemo {
    // 定义标记位，共享变量
    private static volatile boolean on = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyRunnable(), "线程A").start();
        // 先睡眠一会，让程序将数据放入缓存
        Thread.sleep(1000);
        // 修改标记位为false
        on = false;
        Thread.sleep(1000);
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (on) {
//                System.out.println(Thread.currentThread().getName() + "正在执行！");
            }
            System.out.println("程序执行完成，退出线程:" + Thread.currentThread().getName());
        }
    }
}
