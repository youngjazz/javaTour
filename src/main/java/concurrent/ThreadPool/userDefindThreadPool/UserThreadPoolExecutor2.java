package concurrent.ThreadPool.userDefindThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangyang on 2017/9/9.
 */
public class UserThreadPoolExecutor2 implements Runnable{

	private static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 与有界队列相比,使用无界队列时,若新的任务需要执行时,当达到corePoolSize之后就不会继续增加.若后续任由新的任务加入
		 * 而且没有闲置的线程,会被加入到队列中等待. 如任务创建速度远大于处理速度,无界队列会快速增长, 直至系统内存耗尽
		*/
		LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();

		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
				5,
				10,
				60,
				TimeUnit.SECONDS,
				queue                      //指定存放队列, 此处选用有界队列
		);


		for (int i = 0; i < 20; i++) {
			poolExecutor.execute(new UserThreadPoolExecutor2());
		}
		Thread.sleep(1000);
		System.out.println("queue size: "+queue.size());
		Thread.sleep(2000);
	}

	@Override
	public void run() {
		int temp = count.incrementAndGet();
		System.out.println("任务:"+temp);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
