package concurrent.ThreadPool;

import java.security.Provider;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhangyang on 2017/9/4.
 */
public class Main {
	public static void main(String[] args) {
		//内存缓存区
		BlockingQueue<Data> queue = new LinkedBlockingDeque<Data>(10);

		//生产者
		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		Producer p3 = new Producer(queue);
		//消费者
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);

		//创建线程池, 这是一个缓存线程池, 可以创建无穷大的线程, 没有任务的时候不创建线程, 空闲线程存活时间为60s(默认)
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		cachedThreadPool.execute(p1);
		cachedThreadPool.execute(p2);
		cachedThreadPool.execute(p3);
		cachedThreadPool.execute(c1);
		cachedThreadPool.execute(c2);
		cachedThreadPool.execute(c3);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		p1.stop();
		p2.stop();
		p3.stop();

	}
}
