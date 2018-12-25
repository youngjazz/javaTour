package concurrent.ProducerAndConsumer2;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/24 09:16
 */
public class Consumer implements Runnable {
	private BlockingQueue<PCData> queue; //缓冲区
	
	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("start consume id="+Thread.currentThread().getId());
		Random random = new Random();
		
		try {
			while (true){
				PCData data = queue.take(); //提取任务
				if(null != data){
					int re = data.getValue() * data.getValue(); //计算平方
					System.out.println(MessageFormat.format("{0}*{1}={2}",data.getValue(),data.getValue(),re));
					Thread.sleep(random.nextInt(1000));
				}
			}
		}catch (InterruptedException e){
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
