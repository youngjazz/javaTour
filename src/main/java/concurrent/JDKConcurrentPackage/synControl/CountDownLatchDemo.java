package concurrent.JDKConcurrentPackage.synControl;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION：倒计时器
 *
 * @author zhangyang 2018/3/12 23:27
 */
public class CountDownLatchDemo implements Runnable{
	static final CountDownLatchDemo demo = new CountDownLatchDemo();
	static final CountDownLatch end = new CountDownLatch(10);
	@Override
	public void run() {
		//模拟检查任务
		try {
			Thread.sleep(new Random().nextInt(10)*100);
			System.out.println("check complete");
			end.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 21; i++) {
			executorService.submit(demo);
		}
		//等待检查
		end.await();
		//发射火箭
		System.out.println("Fire");
		executorService.shutdown();
	}
}
