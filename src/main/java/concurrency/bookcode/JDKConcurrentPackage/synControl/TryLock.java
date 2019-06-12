package concurrency.bookcode.JDKConcurrentPackage.synControl;

import java.util.concurrent.locks.ReentrantLock;

/**
 * DESCRIPTION：无参tryLock() 如果锁被其他前程占有,不会等待而是立即返回false
 * 这种模式不会引起线程等待,故不会发生死锁
 *
 * @author zhangyang 2017/12/14 09:59
 */
public class TryLock implements Runnable {

    public ReentrantLock lock1 = new ReentrantLock();
    public ReentrantLock lock2 = new ReentrantLock();
    int                  lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                try {
                    if (lock1.tryLock()) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (lock2.tryLock()) {
                        System.out.println(Thread.currentThread().getId() + ": My job done");
                        lock2.unlock();
                        return;
                    }
                } finally {
                    lock1.unlock();
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (lock1.tryLock()) {
                            System.out.println(Thread.currentThread().getId() + ": my job done");
                            lock1.unlock();
                            return;
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }

}
