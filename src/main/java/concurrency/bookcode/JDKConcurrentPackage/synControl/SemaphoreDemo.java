package concurrency.bookcode.JDKConcurrentPackage.synControl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * DESCRIPTION：信号量：允许多个线程同时访问
 *
 * @author zhangyang 2018/3/3 23:29
 */
public class SemaphoreDemo implements Runnable{
	final Semaphore semaphore = new Semaphore(5);
	@Override
	public void run() {
		try {
			semaphore.acquire();
			
			//模拟耗时
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId()+":done");
			
			semaphore.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		final SemaphoreDemo demo = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			executorService.execute(demo);
		}
	}
}
