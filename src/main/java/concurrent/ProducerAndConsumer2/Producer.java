package concurrent.ProducerAndConsumer2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DESCRIPTION：
 *
 * @author zhangyang 2018/4/24 09:06
 */
public class Producer implements Runnable {
    private volatile boolean      isRunning = true;
    private BlockingQueue<PCData> queue;           //内存缓冲区
	private static AtomicInteger count = new AtomicInteger(); //总数，原子操作

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
	    Random random = new Random();
        try {
            while (isRunning) {
                Thread.sleep(random.nextInt(1000)); //模拟业务逻辑耗时
	            PCData data = new PCData(count.incrementAndGet());
	            System.out.println(data + " is put into queue");
	            if(!queue.offer(data,2,TimeUnit.SECONDS)){
		            System.err.println("failed to put data: "+data);
	            }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
