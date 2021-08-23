package multiThreadCommunication;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义互斥锁
 * 实现Lock接口，对外部提供服务
 */
public class AQS implements Lock, java.io.Serializable {
    /**
     * 内部继承抽象队列同步器
     * 实现对应的获取、释放共享资源的方法
     * 供自定义互斥锁内部使用
     */
    private static class Sync extends AbstractQueuedLongSynchronizer {
        /**
         * 判断是否处于锁定状态
         */
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 尝试获取资源
         * 立即返回
         * 成功返回true，否则false
         */
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;
            // 如果状态由0改成1成功，说明获得了共享资源
            if (compareAndSetState(0, 1)) {
                // 设置当前资源独占共享资源
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**尝试释放资源 */
        public boolean tryRelease(int releases) {
            assert releases == 1;
            // 如果此时已经释放了，则不合法
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    // 真正同步类的实现都依赖于继承AQS的自定义同步器
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }
}
