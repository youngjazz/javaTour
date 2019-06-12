package concurrency.bookcode.JDKConcurrentPackage.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/2 15:43
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		MyTask mytask = new MyTask();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService.submit(mytask);
		}
	}
	
	public static class MyTask implements Runnable{
		
		@Override
		public void run() {
			System.out.println(System.currentTimeMillis() + ":Thread ID:"+ Thread.currentThread().getId());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
