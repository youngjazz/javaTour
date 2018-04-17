package concurrent.JDKConcurrentPackage.synControl;

import java.util.concurrent.locks.ReentrantLock;

/**
 * DESCRIPTION：重入锁
 * 重入锁完全可以替代synchronized关键字，远优于synchronized，但JDK之后synchronized做了大量优化。差距不大
 *
 * @author zhangyang 2017/12/11 20:06
 */
public class ReenterLock implements Runnable {
	
	public static ReentrantLock reentrantLock = new ReentrantLock();
	public static int i = 0;
	@Override
	public void run() {
		for (int j = 0; j < 10000000; j++) {
			reentrantLock.lock();
			reentrantLock.lock();//这就是之所以叫重入锁的原因（局限于一个线程），而不会和自己产生死锁
			try {
				i++;
			}finally {
//				reentrantLock.unlock();
				reentrantLock.unlock();
				reentrantLock.unlock();//不过，多少次加锁就要对应次数的释放锁
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLock lock = new ReenterLock();
		Thread t1 = new Thread(lock);
		Thread t2 = new Thread(lock);
		
		t1.start();t2.start();
		t1.join();t2.join();
		
		System.out.println(i);
	}
}
