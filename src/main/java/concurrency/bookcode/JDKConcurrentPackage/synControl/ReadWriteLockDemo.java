package concurrency.bookcode.JDKConcurrentPackage.synControl;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * DESCRIPTION：
 *
 * @author zhangyang 2018/3/12 22:54
 */
public class ReadWriteLockDemo {
	private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int value;
	
	public static void main(String[] args) {
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		Runnable readRunable = new Runnable() {
			@Override
			public void run() {
				try {
					demo.handleRead(readLock);
//					demo.handleRead(lock);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				demo.handleWrite(writeLock,new Random().nextInt());
//				demo.handleWrite(lock,new Random().nextInt());
			}
		};
		
		for (int i = 0; i < 18; i++) {
			new Thread(readRunable).start();
		}
		
		for (int i =18; i < 20; i++) {
			new Thread(writeRunnable).start();
		}
	}
	
	public Object handleRead(Lock lock) throws InterruptedException {
		lock.lock();
		try {
			//模拟读操作
			Thread.sleep(1000);
			return value;
		}finally {
			lock.unlock();
		}
	}
	
	public void handleWrite(Lock lock,int index){
		lock.lock();
		try {
			//模拟写操作
			Thread.sleep(1000);
			value = index;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
