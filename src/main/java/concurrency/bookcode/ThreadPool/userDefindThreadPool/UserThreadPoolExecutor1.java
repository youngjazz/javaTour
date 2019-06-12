package concurrency.bookcode.ThreadPool.userDefindThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyang on 2017/9/9.
 */
public class UserThreadPoolExecutor1 {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 使用有界队列是,若新的任务需要执行时,如果线程池实际线程数小于corePoolSize,则优先创建线程
		 * 若大于corePoolSize, 则会将新的任务加入队列
		 * 若队列已满, 则在总线程数不大于maximumPoolSize前提下,创建新线程;否则执行拒绝策略, 或者其他自定义方式
		 *
		 * JDK拒绝策略:
		 * AbortPolicy
		 * CallerRunsPolicy
		 * DiscardOldestPolicy
		 * DiscardPolicy
		 *
		 * 以上四种都不友好, 如果需要可自己实现,比如记录日志,或者给其他系统发消息;需实现RejectedExecutionHandler接口
		*/

		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				1,
				2,
				60,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(3),//指定存放队列, 此处选用有界队列
				new ThreadPoolExecutor.DiscardOldestPolicy() //拒绝策略, 此处选择丢弃最老的任务
		);


		Mytask t1 = new Mytask(1,"任务1");
		Mytask t2 = new Mytask(2,"任务2");
		Mytask t3 = new Mytask(3,"任务3");
		Mytask t4 = new Mytask(4,"任务4");
		Mytask t5 = new Mytask(5,"任务5");
		Mytask t6 = new Mytask(6,"任务6");
		Mytask t7 = new Mytask(7,"任务7");

		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
//		Thread.sleep(1000);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.execute(t7);

	}
}
