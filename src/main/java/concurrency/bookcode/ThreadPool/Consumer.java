package concurrency.bookcode.ThreadPool;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangyang on 2017/9/4.
 */
public class Consumer implements Runnable{

	private BlockingQueue<Data> queue;

	public Consumer(BlockingQueue<Data> queue) {
		this.queue = queue;
	}

	private Random r = new Random();
	@Override
	public void run() {
		while (true){
			try {
				//模拟消费者耗时
				Thread.sleep(r.nextInt(500));
				Data data = this.queue.take();
				System.out.println("当前消费线程:"+Thread.currentThread().getName()+", 消费成功, id:"+data.getId()+", name:"+data.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
