package concurrency.bookcode.JDKConcurrentPackage.synControl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * DESCRIPTION：重入锁的好搭档：conditon条件
 *
 * @author zhangyang 2018/1/21 23:24
 */
public class ReenterLockCondition implements Runnable {
	
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	
	@Override
	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition rlc =new ReenterLockCondition();
		Thread t1 = new Thread(rlc);
		
		t1.start();
		t1.sleep(2000);
		
		//通知线程t1继续执行
		lock.lock();
		condition.signal();
		lock.unlock();
	}
}
