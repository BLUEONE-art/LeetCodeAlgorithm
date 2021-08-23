package multiThreadCommunication;

public class Add100Times {
    // 如果不加volatile关键字，两个线程各自从缓存中拿到i，进行++，结果最小应该为100
    public static volatile Integer i = 0;

    public void add() {
        int count = 0;
        while (true) {
            if (count >= 10) {
                break;
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "：" + i);
            count++;
        }

        System.out.println(Thread.currentThread().getName() + "：" + i);
    }

    public static void main(String[] args) throws InterruptedException {
        Add100Times add100Times = new Add100Times();
        Thread t1 = new Thread(add100Times::add, "线程A");
        Thread t2 = new Thread(add100Times::add, "线程B");
//        Thread.sleep(100);
        t1.start();
        t2.start();
    }
}
