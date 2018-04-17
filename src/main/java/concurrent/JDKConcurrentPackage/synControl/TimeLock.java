package concurrent.JDKConcurrentPackage.synControl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * DESCRIPTION：除了等待外部通知外,要避免死锁还有另一种办法:那就是限时等待
 *
 * @author zhangyang 2017/12/14 09:43
 */
public class TimeLock implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)){
				Thread.sleep(6000);
			}else{
				System.out.println(Thread.currentThread().getId()+" get lock failed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
				System.out.println(Thread.currentThread().getId()+" unlock");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TimeLock timeLock = new TimeLock();
		Thread t1 = new Thread(timeLock);
		Thread t2 = new Thread(timeLock);
		
		t1.start();t2.start();

	}
}
