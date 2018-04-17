package concurrent.ThreadPool;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangyang on 2017/9/4.
 */
public class Producer implements Runnable{

	//共享缓存区
	private BlockingQueue<Data> queue;

	//多线程间是否启动变量, 有强制从主内存刷新的功能, 即时返回线程状态
	private volatile  boolean isRunning = true;

	//id生成器
	private static AtomicInteger count = new AtomicInteger();

	//随机对象
	private static Random r = new Random();

	public Producer(BlockingQueue<Data> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(isRunning){
			try {
				//模拟生产耗时
				Thread.sleep(r.nextInt(500));
				//获取数据进行累加
				int id = count.incrementAndGet();
				Data data = new Data(id, "数据"+id);
				System.out.println("线程"+Thread.currentThread().getName()+",获取了数据,id:"+id+", 装载到公共缓冲区```");
				if(!this.queue.offer(data, 2, TimeUnit.SECONDS)){
					System.out.println("提交缓存区失败```");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		this.isRunning = false;
	}
}
